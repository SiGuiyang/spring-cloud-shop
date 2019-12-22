package quick.pager.shop.manage.controller.activity;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.response.coupon.DiscountCouponTemplateResponse;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.manage.param.coupon.DiscountCouponTemplatePageParam;
import quick.pager.shop.manage.param.coupon.DiscountCouponTemplateSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.activity.CouponTemplateService;

/**
 * 优惠券模板
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class CouponTemplateManageController {

    @Autowired
    private CouponTemplateService couponTemplateService;

    /**
     * 优惠券模板列表
     */
    @PostMapping("/activity/coupon/template/list")
    public Response<List<DiscountCouponTemplateResponse>> template(@RequestBody DiscountCouponTemplatePageParam param) {
        return couponTemplateService.template(param);
    }

    /**
     * 优惠券模板修改
     */
    @PutMapping("/activity/coupon/template/modify")
    public Response modify(@RequestBody DiscountCouponTemplateSaveParam param) {
        if (Objects.isNull(param.getId())) {
            return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return couponTemplateService.modify(param);
    }

    /**
     * 优惠券模板新增
     */
    @PostMapping("/activity/coupon/template/create")
    public Response create(@RequestBody DiscountCouponTemplateSaveParam param) {
        return couponTemplateService.create(param);
    }
}
