package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.activity.response.coupon.CouponResponse;
import quick.pager.shop.user.response.Response;

/**
 * 优惠券服务
 *
 * @author siguiyang
 */
public interface AppDiscountCouponService {

    /**
     * 查询用户优惠券列表
     *
     * @param userId  当前用户主键
     */
    Response<List<CouponResponse>> queryCoupons(final Long userId);
}
