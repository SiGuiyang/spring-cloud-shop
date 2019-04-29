package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.CouponTemplateDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.client.CouponTemplateClientService;

@Api(description = "优惠券管理")
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
public class CouponTemplateController {


    @Autowired
    private CouponTemplateClientService couponTemplateClientService;

    @ApiOperation("优惠券模板列表")
    @PostMapping("/coupon/template")
    public Response template(@RequestBody CouponTemplateDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return couponTemplateClientService.doService(dto);
    }

    @ApiOperation("优惠券模板修改")
    @PutMapping("/coupon/template/modify")
    public Response modifyTemplate(@RequestBody CouponTemplateDTO dto) {
        dto.setEvent(Constants.Event.MODIFY);
        return couponTemplateClientService.doService(dto);
    }

    @ApiOperation("优惠券模板新增")
    @PostMapping("/coupon/template/modify")
    public Response addTemplate(@RequestBody CouponTemplateDTO dto) {
        dto.setEvent(Constants.Event.ADD);
        return couponTemplateClientService.doService(dto);
    }

}
