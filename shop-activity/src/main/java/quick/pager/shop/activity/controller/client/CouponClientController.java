package quick.pager.shop.activity.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.activity.service.client.CouponClientService;
import quick.pager.shop.activity.service.client.CouponTemplateClientService;
import quick.pager.shop.activity.service.client.PublishCouponClientService;
import quick.pager.shop.activity.service.client.SingleCouponService;
import quick.pager.shop.feign.dto.CouponDTO;
import quick.pager.shop.feign.dto.CouponTemplateDTO;
import quick.pager.shop.feign.dto.PublishCouponDTO;
import quick.pager.shop.feign.request.CouponRequest;
import quick.pager.shop.feign.request.CouponTemplateRequest;
import quick.pager.shop.model.activity.DiscountCoupon;

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
    public Response template(@RequestBody CouponTemplateRequest request) {
        CouponTemplateDTO dto = new CouponTemplateDTO();
        dto.setTemplateName(request.getTemplateName());
        dto.setTemplateType(request.getTemplateType());
        dto.setPage(request.getPage());
        dto.setPageSize(request.getPageSize());
        dto.setEvent(Constants.Event.LIST);
        return couponTemplateClientService.doService(dto);
    }

    @ApiOperation("优惠券模板新增或删除")
    @PostMapping("/coupon/template/modify")
    public Response modifyTemplate(@RequestBody CouponTemplateRequest request) {
        CouponTemplateDTO dto = new CouponTemplateDTO();
        dto.setId(request.getId());
        dto.setTemplateName(request.getTemplateName());
        dto.setTemplateType(request.getTemplateType());
        dto.setCouponAmount(request.getCouponAmount());
        dto.setOrderAmount(request.getOrderAmount());
        dto.setCreateUser(request.getCreateUser());
        dto.setDiscountStrength(request.getDiscountStrength());
        dto.setDescription(request.getDescription());
        dto.setDeleteStatus(request.getDeleteStatus());
        dto.setEvent(request.getEvent());

        return couponTemplateClientService.doService(dto);
    }

    @ApiOperation("用户优惠券列表")
    @PostMapping("/coupon/list")
    public Response coupons(@RequestBody CouponRequest request) {
        CouponDTO dto = new CouponDTO();
        dto.setCouponName(request.getCouponName());
        dto.setPhone(request.getPhone());
        dto.setDiscountType(request.getDiscountType());
        dto.setBeginTime(request.getBeginTime());
        dto.setEndTime(request.getEndTime());
        dto.setPage(request.getPage());
        dto.setPageSize(request.getPageSize());
        dto.setEvent(Constants.Event.LIST);
        return couponClientService.doService(dto);
    }


    @ApiOperation("获取一张优惠券详情")
    @PostMapping("/userCoupons/{couponId}")
    public Response<DiscountCoupon> userCoupons(@PathVariable("couponId") Long couponId) {

        return new Response<>(singleCouponService.getCoupons(couponId));
    }

}
