package quick.pager.shop.manage.controller.activity;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.client.ActivityClient;
import quick.pager.shop.feign.dto.CouponDTO;
import quick.pager.shop.feign.dto.CouponTemplateDTO;

@Api(description = "优惠券")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class CouponController {

    @Autowired
    private ActivityClient activityClient;

    @ApiOperation("发送优惠券")
    @PostMapping("/publish/coupon")
    public Response publishCoupon(@RequestParam String file, @RequestParam Long templateId) {
        return activityClient.publishCoupon(file, templateId);
    }

    @HystrixCommand
    @ApiOperation("优惠券模板列表")
    @PostMapping("/activity/coupon/template")
    public Response template(CouponTemplateDTO dto) {
        return activityClient.template(dto);
    }

    @ApiOperation("优惠券模板新增或删除")
    @PostMapping("/activity/coupon/template/modify")
    public Response modifyTemplate(CouponTemplateDTO dto) {
        return activityClient.modifyTemplate(dto);
    }

    @HystrixCommand
    @ApiOperation("用户优惠券列表")
    @PostMapping("/activity/coupon/list")
    public Response coupons(CouponDTO dto) {
        return activityClient.coupons(dto);
    }
}
