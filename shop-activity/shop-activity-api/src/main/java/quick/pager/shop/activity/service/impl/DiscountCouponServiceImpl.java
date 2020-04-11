package quick.pager.shop.activity.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import java.io.DataInputStream;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.mapper.DiscountCouponTemplateMapper;
import quick.pager.shop.activity.model.DiscountCoupon;
import quick.pager.shop.activity.model.DiscountCouponTemplate;
import quick.pager.shop.activity.request.coupon.DiscountCouponPageRequest;
import quick.pager.shop.activity.response.coupon.DiscountCouponResponse;
import quick.pager.shop.constants.RedisKeys;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.activity.mapper.DiscountCouponMapper;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.DiscountCouponService;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.activity.task.SendCouponTask;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.user.client.UserClient;
import quick.pager.shop.user.request.UserRequest;
import quick.pager.shop.user.response.UserInfoResponse;
import quick.pager.shop.utils.DateUtils;
import quick.pager.shop.utils.FileUtil;

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
    private RedisService redisService;
    @Autowired
    private UserClient userClient;

    @Override
    public Response<List<DiscountCouponResponse>> queryPage(DiscountCouponPageRequest request) {

        LambdaQueryWrapper<DiscountCoupon> qw = new LambdaQueryWrapper<>();

        if (StringUtils.isNotEmpty(request.getPhone())) {
            qw.eq(DiscountCoupon::getPhone, request.getPhone());
        }
        if (CollectionUtils.isNotEmpty(request.getTimeRange())) {
            qw.ge(DiscountCoupon::getCreateTime, request.getTimeRange().get(0));
            qw.le(DiscountCoupon::getCreateTime, request.getTimeRange().get(1));
        } else {
            qw.apply("DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= create_time");
        }

        Response<List<DiscountCoupon>> response = this.toPage(request.getPage(), request.getPageSize(), qw);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert).collect(Collectors.toList()),
                response.getTotal());
    }

    @Override
    public Response<DiscountCouponResponse> info(Long id) {
        return new Response<>(this.convert(this.getById(id)));
    }


    @Override
    public Response publish(String file, Long templateId) {

        DiscountCouponTemplate template = discountCouponTemplateMapper.selectById(templateId);

        // 选择的优惠券模板可用
        if (Objects.nonNull(template)) {
            log.info("选择的优惠券模板可用 templateId = {}", templateId);
            DataInputStream inputStream = null;

            try {

                inputStream = FileUtil.getRemoteFile(file);
                // 初始设置补发优惠券的大小
                List<String> phones = Lists.newArrayList();
                Excel07SaxReader reader = new Excel07SaxReader((sheetIndex, rowIndex, rowList) -> {
                    // 过滤掉标题
                    if (0 != rowIndex) {
                        phones.add(rowList.get(0).toString());
                    }
                });

                reader.read(inputStream, 0);

                if (CollectionUtils.isEmpty(phones)) {
                    log.info("excel 文件中没有用户手机号");
                    return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PUBLISH_COUPON_PHONE_IS_BLANK);
                }

                UserRequest request = new UserRequest();
                request.setPhones(phones);
                // 取出正常的用户
                Response<List<UserInfoResponse>> existsResponse = userClient.isExists(request);

                List<UserInfoResponse> exists = null;
                if (ResponseStatus.Code.SUCCESS == existsResponse.getCode() && null != existsResponse.getData()) {
                    exists = existsResponse.getData();
                }

                if (!CollectionUtils.isEmpty(exists)) {
                    log.info("查询到用户");
                    // 当前补发优惠券的人数大于1000，则采用线程方式发送
                    if (exists.size() >= 1000) {
                        // 多线程执行后返回正常的插入的手机号
                        List<String> list = new ForkJoinPool(2).invoke(new SendCouponTask(exists, template, this.baseMapper));

                        // 移除发送正常的手机号码
                        phones.removeAll(list);

                    } else {

                        exists.forEach(v -> {

                            DiscountCoupon discountCoupon = new DiscountCoupon();
                            discountCoupon.setUserId(v.getId());
                            discountCoupon.setTemplateId(template.getId());
                            discountCoupon.setPhone(v.getPhone());
                            discountCoupon.setUsed(Boolean.FALSE);
                            discountCoupon.setCreateTime(DateUtils.dateTime());
                            discountCoupon.setUpdateTime(DateUtils.dateTime());
                            discountCoupon.setDeleteStatus(Boolean.FALSE);

                            this.baseMapper.insert(discountCoupon);

                        });

                    }

                    // 最后得到的phones 存在的值必然是错误用户的手机号,这里的错误信息只提供参考，不打算存储在数据库中，放入redis中时效性7d
                    if (!CollectionUtils.isEmpty(phones)) {
                        log.info("存在错误的用户手机号，存在redis中，用于给运营展示");
                        redisService.set(RedisKeys.ManageKeys.SEND_COUPON_LIST + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN), JSON.toJSONString(phones), 7 * 60 * 60 * 24);
                    }
                } else {
                    log.info("未查到用户");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IoUtil.close(inputStream);
            }
        }

        return new Response();
    }


    private DiscountCouponResponse convert(DiscountCoupon coupon) {
        DiscountCouponResponse response = new DiscountCouponResponse();
        DiscountCouponTemplate discountCouponTemplate = discountCouponTemplateMapper.selectById(coupon.getTemplateId());
        response.setId(coupon.getId());
        response.setPhone(coupon.getPhone());
        response.setTemplateName(discountCouponTemplate.getTemplateName());
        response.setOrderAmount(discountCouponTemplate.getOrderAmount());
        response.setCouponAmount(discountCouponTemplate.getCouponAmount());
        response.setDiscountStrength(discountCouponTemplate.getDiscountStrength());
        response.setTemplateType(discountCouponTemplate.getTemplateType());
        response.setBeginTime(discountCouponTemplate.getBeginTime());
        response.setEndTime(discountCouponTemplate.getEndTime());
        response.setCreateTime(coupon.getCreateTime());

        Response<UserInfoResponse> responseRes = userClient.getUser(coupon.getUserId());
        response.setUsername(Objects.nonNull(responseRes.getData()) ? responseRes.getData().getUsername() : null);

        return response;
    }

}
