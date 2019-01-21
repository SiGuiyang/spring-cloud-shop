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
import quick.pager.shop.manage.client.ActivityClient;
import quick.pager.shop.model.feign.request.CouponRequest;
import quick.pager.shop.model.feign.request.CouponTemplateRequest;

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
    public Response template(CouponTemplateRequest request) {
        return activityClient.template(request);
    }

    @ApiOperation("优惠券模板新增或删除")
    @PostMapping("/activity/coupon/template/modify")
    public Response modifyTemplate(CouponTemplateRequest request) {
        return activityClient.modifyTemplate(request);
    }

    @HystrixCommand
    @ApiOperation("用户优惠券列表")
    @PostMapping("/activity/coupon/list")
    public Response coupons(CouponRequest request) {
        return activityClient.coupons(request);
    }
}
