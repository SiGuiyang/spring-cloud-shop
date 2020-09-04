package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.activity.enums.AppCouponUseTypeEnum;
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
     * @param page    页码
     * @param useType 使用方式
     */
    Response<List<CouponResponse>> queryCoupons(final Long userId, final Integer page, final AppCouponUseTypeEnum useType);
}
