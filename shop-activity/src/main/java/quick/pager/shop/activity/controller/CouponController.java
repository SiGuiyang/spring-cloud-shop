package quick.pager.shop.activity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.activity.request.GiftCouponRequest;
import quick.pager.shop.activity.service.CouponService;
import quick.pager.shop.activity.service.GiftCouponService;

/**
 * 优惠券接口
 *
 * @author siguiyang
 */
@RestController
@Slf4j
@RequestMapping(Constants.Module.ACTIVITY)
@Api(description = "优惠券接口")
public class CouponController {

    @Autowired
    private CouponService couponService;
    @Autowired
    private GiftCouponService giftCouponService;

    @RequestMapping(value = "/coupons/{userId}", method = RequestMethod.POST)
    @ApiOperation("用户优惠券列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "Long", paramType = "query")})
    public Response coupons(@PathVariable("userId") Long userId) {
        return null;
    }

    @ApiOperation("赠送优惠券")
    @RequestMapping(value = "/coupons/gift", method = RequestMethod.POST)
    public Response giftCoupon(GiftCouponRequest request) {
        return null;
    }

}
