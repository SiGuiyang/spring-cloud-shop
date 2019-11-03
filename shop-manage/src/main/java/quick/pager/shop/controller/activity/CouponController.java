package quick.pager.shop.controller.activity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(description = "优惠券")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class CouponController {

    @Autowired
    private CouponService couponService;

    @ApiOperation("发送优惠券")
    @PostMapping("/publish/coupon")
    public Response publishCoupon(@RequestParam String file, @RequestParam Long templateId) {
        return couponService.publishCoupon(file, templateId);
    }

    @ApiOperation("用户优惠券列表")
    @PostMapping("/activity/coupon/list")
    public Response coupons(@RequestBody CouponDTO dto) {
        return couponService.coupons(dto);
    }
}
