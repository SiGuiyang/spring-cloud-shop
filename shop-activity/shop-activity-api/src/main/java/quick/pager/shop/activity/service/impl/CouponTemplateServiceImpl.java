package quick.pager.shop.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.activity.model.DiscountCouponTemplate;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplatePageRequest;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplateSaveRequest;
import quick.pager.shop.activity.mapper.DiscountCouponTemplateMapper;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.CouponTemplateService;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

@Service
public class CouponTemplateServiceImpl extends ServiceImpl<DiscountCouponTemplateMapper, DiscountCouponTemplate> implements CouponTemplateService {
    @Override
    public Response<List<DiscountCouponTemplate>> queryPage(DiscountCouponTemplatePageRequest request) {

        QueryWrapper<DiscountCouponTemplate> qw = new QueryWrapper<>();

        if (!StringUtils.isEmpty(request.getTemplateName())) {
            qw.likeRight("template_name", request.getTemplateName());
        }

        if (null != request.getTemplateType()) {
            qw.eq("template_type", request.getTemplateType());
        }

        qw.orderByDesc("id");

        return this.toPage(request.getPage(), request.getPageSize(), qw);
    }


    @Override
    public Response<Long> create(DiscountCouponTemplateSaveRequest request) {
        DiscountCouponTemplate template = new DiscountCouponTemplate();
        BeanCopier.create(request, template).copy();
        template.setDeleteStatus(Boolean.FALSE);
        template.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(template);

        return new Response<>(template.getId());
    }

    @Override
    public Response<Long> modify(DiscountCouponTemplateSaveRequest request) {
        DiscountCouponTemplate template = new DiscountCouponTemplate();
        BeanCopier.create(request, template).copy();
        this.baseMapper.updateById(template);

        return new Response<>(template.getId());
    }

    @Override
    public DiscountCouponTemplate info(Long id) {
        DiscountCouponTemplate template = this.baseMapper.selectById(id);

        if (Objects.isNull(template)) {
            return null;
        }

        return template;
    }
}
