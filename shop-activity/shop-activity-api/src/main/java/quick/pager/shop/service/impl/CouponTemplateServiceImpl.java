package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import quick.pager.shop.model.DiscountCouponTemplate;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplatePageRequest;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplateSaveRequest;
import quick.pager.shop.mapper.DiscountCouponTemplateMapper;
import quick.pager.shop.activity.response.coupon.DiscountCouponTemplateResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.CouponTemplateService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * 优惠券模板
 *
 * @author siguiyang
 */
@Service
public class CouponTemplateServiceImpl extends ServiceImpl<DiscountCouponTemplateMapper, DiscountCouponTemplate> implements CouponTemplateService {
    @Override
    public Response<List<DiscountCouponTemplateResponse>> queryPage(DiscountCouponTemplatePageRequest request) {

        Response<List<DiscountCouponTemplate>> page = this.toPage(request.getPage(), request.getPageSize(), new LambdaQueryWrapper<DiscountCouponTemplate>()
                .likeRight(StringUtils.isNotEmpty(request.getTemplateName()), DiscountCouponTemplate::getTemplateName, request.getTemplateName())
                .eq(Objects.nonNull(request.getTemplateType()), DiscountCouponTemplate::getTemplateType, request.getTemplateType())
                .orderByDesc(DiscountCouponTemplate::getUpdateTime));

        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList()), page.getTotal());
    }


    @Override
    public Response<Long> create(DiscountCouponTemplateSaveRequest request) {
        DiscountCouponTemplate template = new DiscountCouponTemplate();
        BeanCopier.create(request, template).copy();
        template.setDeleteStatus(Boolean.FALSE);
        template.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(template);

        return Response.toResponse(template.getId());
    }

    @Override
    public Response<Long> modify(DiscountCouponTemplateSaveRequest request) {
        DiscountCouponTemplate template = new DiscountCouponTemplate();
        BeanCopier.create(request, template).copy();
        this.baseMapper.updateById(template);

        return Response.toResponse(template.getId());
    }

    @Override
    public DiscountCouponTemplateResponse info(Long id) {
        DiscountCouponTemplate template = this.baseMapper.selectById(id);

        if (Objects.isNull(template)) {
            return null;
        }

        return this.convert(template);
    }


    private DiscountCouponTemplateResponse convert(DiscountCouponTemplate template) {
        if (Objects.isNull(template)) {
            return null;
        }
        DiscountCouponTemplateResponse response = new DiscountCouponTemplateResponse();
        BeanCopier.create(template, response).copy();

        return response;
    }
}
