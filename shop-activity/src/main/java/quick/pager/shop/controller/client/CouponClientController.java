package quick.pager.shop.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.client.CouponClientService;
import quick.pager.shop.service.client.CouponTemplateClientService;
import quick.pager.shop.service.client.PublishCouponClientService;
import quick.pager.shop.service.client.SingleCouponService;
import quick.pager.shop.dto.CouponDTO;
import quick.pager.shop.dto.CouponTemplateDTO;
import quick.pager.shop.dto.PublishCouponDTO;
import quick.pager.shop.model.DiscountCoupon;

@Api(description = "优惠券")
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
public class CouponClientController {

    @Autowired
    private CouponClientService couponClientService;
    @Autowired
    private CouponTemplateClientService couponTemplateClientService;
    @Autowired
    private PublishCouponClientService publishCouponClientService;
    @Autowired
    private SingleCouponService singleCouponService;

    @ApiOperation("发送优惠券")
    @PostMapping("/publish/coupon")
    public Response publishCoupon(@RequestParam String file, @RequestParam Long templateId) {
        PublishCouponDTO dto = new PublishCouponDTO();
        dto.setFile(file);
        dto.setTemplateId(templateId);
        return publishCouponClientService.doService(dto);
    }

    @ApiOperation("优惠券模板列表")
    @PostMapping("/coupon/template")
    public Response template(@RequestBody CouponTemplateDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return couponTemplateClientService.doService(dto);
    }

    @ApiOperation("优惠券模板新增或删除")
    @PostMapping("/coupon/template/modify")
    public Response modifyTemplate(@RequestBody CouponTemplateDTO dto) {

        return couponTemplateClientService.doService(dto);
    }

    @ApiOperation("用户优惠券列表")
    @PostMapping("/coupon/list")
    public Response coupons(@RequestBody CouponDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return couponClientService.doService(dto);
    }


    @ApiOperation("获取一张优惠券详情")
    @PostMapping("/userCoupons/{couponId}")
    public Response<DiscountCoupon> userCoupons(@PathVariable("couponId") Long couponId) {

        return new Response<>(singleCouponService.getCoupons(couponId));
    }

}
