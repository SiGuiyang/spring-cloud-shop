package quick.pager.shop.manage.service.activity.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.client.DiscountCouponClient;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplatePageRequest;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplateSaveRequest;
import quick.pager.shop.activity.response.coupon.DiscountCouponTemplateResponse;
import quick.pager.shop.manage.param.coupon.DiscountCouponTemplatePageParam;
import quick.pager.shop.manage.param.coupon.DiscountCouponTemplateSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.activity.CouponTemplateService;
import quick.pager.shop.utils.BeanCopier;

@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Autowired
    private DiscountCouponClient discountCouponClient;

    @Override
    public Response<List<DiscountCouponTemplateResponse>> template(DiscountCouponTemplatePageParam param) {
        DiscountCouponTemplatePageRequest request = new DiscountCouponTemplatePageRequest();
        BeanCopier.create(param, request).copy();
        return discountCouponClient.queryPage(request);
    }

    @Override
    public Response<Long> modify(DiscountCouponTemplateSaveParam param) {
        DiscountCouponTemplateSaveRequest request = new DiscountCouponTemplateSaveRequest();
        BeanCopier.create(param, request).copy();
        return discountCouponClient.modify(request);
    }

    @Override
    public Response<Long> create(DiscountCouponTemplateSaveParam param) {
        DiscountCouponTemplateSaveRequest request = new DiscountCouponTemplateSaveRequest();
        BeanCopier.create(param, request).copy();
        return discountCouponClient.create(request);
    }
}
