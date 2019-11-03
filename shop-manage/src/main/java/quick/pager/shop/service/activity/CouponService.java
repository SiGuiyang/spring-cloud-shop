package quick.pager.shop.service.activity;

import quick.pager.shop.dto.activity.CouponDTO;
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
    Response coupons(CouponDTO dto);
}
