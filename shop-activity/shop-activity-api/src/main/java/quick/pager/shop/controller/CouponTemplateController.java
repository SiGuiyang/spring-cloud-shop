package quick.pager.shop.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.enums.CouponTypeEnums;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplatePageRequest;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplateSaveRequest;
import quick.pager.shop.activity.response.coupon.DiscountCouponTemplateResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.CouponTemplateService;
import quick.pager.shop.utils.Assert;

/**
 * 优惠券模板管理
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class CouponTemplateController {

    @Autowired
    private CouponTemplateService couponTemplateService;

    /**
     * 优惠券模板列表
     */
    @PostMapping("/coupon/template/page")
    public Response<List<DiscountCouponTemplateResponse>> queryPage(@RequestBody DiscountCouponTemplatePageRequest request) {
        return couponTemplateService.queryPage(request);
    }

    /**
     * 优惠券模板新增
     */
    @PostMapping("/coupon/template/create")
    public Response create(@RequestBody DiscountCouponTemplateSaveRequest request) {
        this.doRequest(request);
        return couponTemplateService.create(request);
    }

    /**
     * 优惠券模板修改
     */
    @PutMapping("/coupon/template/modify")
    public Response<Long> modify(@RequestBody DiscountCouponTemplateSaveRequest request) {
        Assert.isTrue(Objects.nonNull(request.getId()), () -> ResponseStatus.PARAMS_EXCEPTION);
        this.doRequest(request);
        return couponTemplateService.modify(request);
    }

    /**
     * 获取优惠券模板信息
     */
    @GetMapping("/coupon/template/{templateId}")
    public Response<DiscountCouponTemplateResponse> info(@PathVariable("templateId") Long templateId) {
        return Response.toResponse(couponTemplateService.info(templateId));
    }


    /**
     * 处理模板优惠券和折扣券
     *
     * @param request 请求参数
     */
    private void doRequest(DiscountCouponTemplateSaveRequest request) {
        if (null != request.getTemplateType() && null != request.getDiscountStrength()) {
            // 如果是折扣券
            if (CouponTypeEnums.DISCOUNT.getCode().equals(request.getTemplateType())) {
                BigDecimal hundred = new BigDecimal("100");

                Assert.isTrue(hundred.compareTo(request.getDiscountStrength()) > 0, () -> "折扣力度不能必须小于100");
                Assert.isTrue(BigDecimal.ZERO.compareTo(request.getDiscountStrength()) < 0, () -> "折扣力度必须是整数");

                request.setDiscountStrength(request.getDiscountStrength().divide(new BigDecimal("100"), RoundingMode.HALF_UP));
            }
        }
    }

}
