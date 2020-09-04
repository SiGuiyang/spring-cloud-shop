package quick.pager.shop.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.request.coupon.DiscountCouponPageRequest;
import quick.pager.shop.activity.response.coupon.DiscountCouponResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.DiscountCouponService;

/**
 * 优惠券接口
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@Slf4j
@RequestMapping(ConstantsClient.ACTIVITY)
public class CouponController {

    @Autowired
    private DiscountCouponService discountCouponService;

    /**
     * 用户优惠券列表
     */
    @PostMapping("/coupon/page")
    public Response<List<DiscountCouponResponse>> coupons(@RequestBody DiscountCouponPageRequest request) {

        return discountCouponService.queryPage(request);
    }

    /**
     * 获取一张优惠券详情
     */
    @GetMapping("/coupon/{couponId}")
    public Response<DiscountCouponResponse> userCoupons(@PathVariable("couponId") Long couponId) {

        return discountCouponService.info(couponId);
    }

    /**
     * 发送优惠券
     */
    @PostMapping("/coupon/publish")
    public Response publishCoupon(@RequestParam String file, @RequestParam Long templateId) {
        return discountCouponService.publish(file, templateId);
    }

}
