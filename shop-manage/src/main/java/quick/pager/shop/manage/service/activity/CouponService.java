package quick.pager.shop.manage.service.activity;

import java.util.List;
import quick.pager.shop.activity.response.coupon.DiscountCouponResponse;
import quick.pager.shop.manage.param.coupon.DiscountCouponPageParam;
import quick.pager.shop.response.Response;

public interface CouponService {
    /**
     * 批量发送优惠券
     *
     * @param file       文件
     * @param templateId 模板Id
     */
    Response publishCoupon(String file, Long templateId);

    /**
     * 优惠券列表
     */
    Response<List<DiscountCouponResponse>> coupons(DiscountCouponPageParam dto);
}
