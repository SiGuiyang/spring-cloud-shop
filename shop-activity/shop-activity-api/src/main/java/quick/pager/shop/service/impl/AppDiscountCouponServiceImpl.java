package quick.pager.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.enums.AppCouponUseTypeEnum;
import quick.pager.shop.mapper.DiscountCouponMapper;
import quick.pager.shop.mapper.DiscountCouponTemplateMapper;
import quick.pager.shop.activity.response.coupon.CouponResponse;
import quick.pager.shop.service.AppDiscountCouponService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.client.UserClient;

/**
 * @author siguiyang
 */
@Service
public class AppDiscountCouponServiceImpl implements AppDiscountCouponService {

    @Autowired
    private DiscountCouponTemplateMapper discountCouponTemplateMapper;
    @Autowired
    private DiscountCouponMapper discountCouponMapper;
    @Autowired
    private UserClient userClient;

    @Override
    public Response<List<CouponResponse>> queryCoupons(Long userId, Integer page, AppCouponUseTypeEnum useType) {
        return null;
    }
}
