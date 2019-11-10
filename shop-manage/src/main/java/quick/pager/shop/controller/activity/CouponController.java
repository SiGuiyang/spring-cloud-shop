package quick.pager.shop.controller.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.activity.CouponDTO;
import quick.pager.shop.service.activity.CouponService;

/**
 * 优惠券
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class CouponController {

    @Autowired
    private CouponService couponService;

    /**
     * 发送优惠券
     */
    @PostMapping("/publish/coupon")
    public Response publishCoupon(@RequestParam String file, @RequestParam Long templateId) {
        return couponService.publishCoupon(file, templateId);
    }

    /**
     * 用户优惠券列表
     */
    @PostMapping("/activity/coupon/list")
    public Response coupons(@RequestBody CouponDTO dto) {
        return couponService.coupons(dto);
    }
}
