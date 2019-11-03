package quick.pager.shop.controller.activity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.activity.CouponTemplateDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.CouponTemplateService;

@Api(description = "优惠券模板")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class CouponTemplateManageController {

    @Autowired
    private CouponTemplateService couponTemplateService;

    @ApiOperation("优惠券模板列表")
    @PostMapping("/activity/coupon/template/list")
    public Response template(@RequestBody CouponTemplateDTO dto) {
        return couponTemplateService.template(dto);
    }

    @ApiOperation("优惠券模板修改")
    @PutMapping("/activity/coupon/template/modify")
    public Response modify(@RequestBody CouponTemplateDTO dto) {
        return couponTemplateService.modifyTemplate(dto);
    }

    @ApiOperation("优惠券模板新增")
    @PostMapping("/activity/coupon/template/create")
    public Response create(@RequestBody CouponTemplateDTO dto) {
        return couponTemplateService.addTemplate(dto);
    }
}
