package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.AppDTO;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.dto.CouponDTO;
import quick.pager.shop.dto.PublishCouponDTO;
import quick.pager.shop.model.DiscountCoupon;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.CouponService;
import quick.pager.shop.service.GiftCouponService;
import quick.pager.shop.service.client.CouponClientService;
import quick.pager.shop.service.client.PublishCouponClientService;
import quick.pager.shop.service.client.SingleCouponService;

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


    @Autowired
    private CouponClientService couponClientService;
    @Autowired
    private PublishCouponClientService publishCouponClientService;
    @Autowired
    private SingleCouponService singleCouponService;

    @PostMapping("/coupons/{userId}")
    @ApiOperation("用户优惠券列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "Integer", paramType = "query")})
    public Response coupons(@PathVariable("userId") Long userId, @RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        BaseDTO dto = new BaseDTO();
        dto.setId(userId);
        dto.setPage(page);
        dto.setPageSize(pageSize);
        return couponService.doService(dto);
    }

    @ApiOperation("赠送优惠券")
    @RequestMapping(value = "/coupons/gift/{userId}", method = RequestMethod.POST)
    public Response giftCoupon(@PathVariable("userId") Long userId) {
        return giftCouponService.doService(new AppDTO(userId));
    }


    @ApiOperation("发送优惠券")
    @PostMapping("/publish/coupon")
    public Response publishCoupon(@RequestParam String file, @RequestParam Long templateId) {
        PublishCouponDTO dto = new PublishCouponDTO();
        dto.setFile(file);
        dto.setTemplateId(templateId);
        return publishCouponClientService.doService(dto);
    }

    @ApiOperation("用户优惠券列表")
    @PostMapping("/coupon/list")
    public Response coupons(@RequestBody CouponDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return couponClientService.doService(dto);
    }


    @ApiOperation("获取一张优惠券详情")
    @PostMapping("/coupon/{couponId}")
    public Response<DiscountCoupon> userCoupons(@PathVariable("couponId") Long couponId) {

        return new Response<>(singleCouponService.getCoupons(couponId));
    }

}
