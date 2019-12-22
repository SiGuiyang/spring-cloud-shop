package quick.pager.shop.manage.service.activity.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.client.DiscountCouponClient;
import quick.pager.shop.activity.request.coupon.DiscountCouponPageRequest;
import quick.pager.shop.activity.response.coupon.DiscountCouponResponse;
import quick.pager.shop.manage.param.coupon.DiscountCouponPageParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.activity.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private DiscountCouponClient discountCouponClient;

    @Override
    public Response publishCoupon(String file, Long templateId) {
        return discountCouponClient.publishCoupon(file, templateId);
    }

    @Override
    public Response<List<DiscountCouponResponse>> coupons(DiscountCouponPageParam param) {
        DiscountCouponPageRequest request = new DiscountCouponPageRequest();
        request.setPhone(param.getPhone());
        request.setPage(param.getPage());
        request.setPageSize(param.getPageSize());
        request.setTimeRange(param.getTimeRange());
        return discountCouponClient.couponList(request);
    }
}
