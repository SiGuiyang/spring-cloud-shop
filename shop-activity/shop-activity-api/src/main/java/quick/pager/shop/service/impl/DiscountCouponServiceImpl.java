package quick.pager.shop.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import quick.pager.shop.dto.PublishCouponDTO;
import quick.pager.shop.listener.PublishCouponDTOListener;
import quick.pager.shop.mapper.DiscountCouponTemplateMapper;
import quick.pager.shop.model.DiscountCoupon;
import quick.pager.shop.model.DiscountCouponTemplate;
import quick.pager.shop.activity.request.coupon.DiscountCouponPageRequest;
import quick.pager.shop.activity.response.coupon.DiscountCouponResponse;
import quick.pager.shop.mapper.DiscountCouponMapper;
import quick.pager.shop.mq.ActivityMQ;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.DiscountCouponService;
import quick.pager.shop.user.client.UserClient;

/**
 * 优惠券
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class DiscountCouponServiceImpl extends ServiceImpl<DiscountCouponMapper, DiscountCoupon> implements DiscountCouponService {

    @Autowired
    private DiscountCouponTemplateMapper discountCouponTemplateMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private UserClient userClient;
    @Autowired
    private ActivityMQ activityMQ;

    @Override
    public Response<List<DiscountCouponResponse>> queryPage(DiscountCouponPageRequest request) {

        LambdaQueryWrapper<DiscountCoupon> qw = new LambdaQueryWrapper<DiscountCoupon>()
                .eq(StringUtils.isNotEmpty(request.getPhone()), DiscountCoupon::getPhone, request.getPhone());

        if (CollectionUtils.isNotEmpty(request.getTimeRange())) {
            qw.ge(DiscountCoupon::getCreateTime, request.getTimeRange().get(0));
            qw.le(DiscountCoupon::getCreateTime, request.getTimeRange().get(1));
        } else {
            qw.apply("DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= create_time");
        }

        Response<List<DiscountCoupon>> response = this.toPage(request.getPage(), request.getPageSize(), qw);

        return Response.toResponse(response.getData().stream()
                        .map(this::convert).collect(Collectors.toList()),
                response.getTotal());
    }

    @Override
    public Response<List<DiscountCouponResponse>> list(final Long userId) {

        List<DiscountCoupon> discountCoupons = this.baseMapper.selectList(new LambdaQueryWrapper<DiscountCoupon>()
                .eq(DiscountCoupon::getUserId, userId)
                .ge(DiscountCoupon::getBeginTime, LocalDate.now())
                .le(DiscountCoupon::getEndTime, LocalDate.now())
                .eq(DiscountCoupon::getUsed, Boolean.FALSE));

        // 二次查询验证优惠模板是否被禁用
        List<DiscountCouponTemplate> templates = discountCouponTemplateMapper.selectList(new LambdaQueryWrapper<DiscountCouponTemplate>()
                .in(DiscountCouponTemplate::getId, discountCoupons.stream().map(DiscountCoupon::getTemplateId).collect(Collectors.toList()))
                .eq(DiscountCouponTemplate::getState, Boolean.FALSE));

        // 得到未禁用的优惠券模板
        List<Long> templateIds = templates.stream().map(DiscountCouponTemplate::getId).collect(Collectors.toList());

        return Response.toResponse(discountCoupons.stream()
                .filter(item -> templateIds.contains(item.getTemplateId()))
                .map(this::convert).collect(Collectors.toList()));
    }

    @Override
    public Response<DiscountCouponResponse> info(Long id) {
        return Response.toResponse(this.convert(this.getById(id)));
    }


    @Override
    public Response publish(final MultipartFile file, final Long templateId) {


        DiscountCouponTemplate template = discountCouponTemplateMapper.selectById(templateId);

        // 选择的优惠券模板可用
        if (Objects.nonNull(template)) {
            log.info("选择的优惠券模板可用 templateId = {}", templateId);

            try {
                EasyExcel.read(file.getInputStream(), PublishCouponDTO.class,
                        new PublishCouponDTOListener(this.baseMapper, redisTemplate, userClient, activityMQ, template))
                        .sheet()
                        .doRead();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Response.toResponse();
    }


    private DiscountCouponResponse convert(DiscountCoupon coupon) {
        DiscountCouponResponse response = new DiscountCouponResponse();
        DiscountCouponTemplate discountCouponTemplate = discountCouponTemplateMapper.selectById(coupon.getTemplateId());
        response.setId(coupon.getId());
        response.setPhone(coupon.getPhone());
        response.setTemplateName(discountCouponTemplate.getTemplateName());
        response.setOrderAmount(discountCouponTemplate.getOrderAmount());
        response.setDiscountAmount(discountCouponTemplate.getCouponAmount());
        response.setDiscountStrength(discountCouponTemplate.getDiscountStrength());
        response.setTemplateType(discountCouponTemplate.getTemplateType());
        response.setBeginTime(discountCouponTemplate.getBeginTime());
        response.setEndTime(discountCouponTemplate.getEndTime());
        response.setCreateTime(coupon.getCreateTime());

        return response;
    }

}
