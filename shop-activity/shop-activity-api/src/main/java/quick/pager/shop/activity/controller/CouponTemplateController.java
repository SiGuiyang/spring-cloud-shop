package quick.pager.shop.activity.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.model.DiscountCouponTemplate;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplatePageRequest;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplateSaveRequest;
import quick.pager.shop.activity.response.coupon.DiscountCouponTemplateResponse;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.CouponTemplateService;
import quick.pager.shop.utils.BeanCopier;

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
        Response<List<DiscountCouponTemplate>> response = couponTemplateService.queryPage(request);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                response.getTotal());
    }

    /**
     * 优惠券模板新增
     */
    @PostMapping("/coupon/template/create")
    public Response create(@RequestBody DiscountCouponTemplateSaveRequest request) {
        if (null != request.getTemplateType() && null != request.getDiscountStrength()) {
            // 如果是折扣券
            if (Constants.CouponType.DISCOUNT.getType() == request.getTemplateType()) {
                BigDecimal hundred = new BigDecimal("100");

                if (hundred.compareTo(request.getDiscountStrength()) <= 0) {
                    return new Response<>(ResponseStatus.Code.FAIL_CODE, "折扣力度不能必须小于100");
                } else if (BigDecimal.ZERO.compareTo(request.getDiscountStrength()) >= 0) {
                    return new Response<>(ResponseStatus.Code.FAIL_CODE, "折扣力度必须是整数");
                }

                request.setDiscountStrength(request.getDiscountStrength().divide(new BigDecimal("100"), RoundingMode.HALF_UP));
            }

        }

        return couponTemplateService.create(request);
    }

    /**
     * 优惠券模板修改
     */
    @PutMapping("/coupon/template/modify")
    public Response<Long> modify(@RequestBody DiscountCouponTemplateSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        if (null != request.getTemplateType() && null != request.getDiscountStrength()) {
            // 如果是折扣券
            if (Constants.CouponType.DISCOUNT.getType() == request.getTemplateType()) {
                BigDecimal hundred = new BigDecimal("100");

                if (hundred.compareTo(request.getDiscountStrength()) <= 0) {
                    return new Response<>(ResponseStatus.Code.FAIL_CODE, "折扣力度不能必须小于100");
                } else if (BigDecimal.ZERO.compareTo(request.getDiscountStrength()) >= 0) {
                    return new Response<>(ResponseStatus.Code.FAIL_CODE, "折扣力度必须是整数");
                }

                request.setDiscountStrength(request.getDiscountStrength().divide(new BigDecimal("100"), RoundingMode.HALF_UP));
            }

        }
        return couponTemplateService.modify(request);
    }

    /**
     * 获取优惠券模板信息
     */
    @GetMapping("/coupon/template/{templateId}")
    public Response<DiscountCouponTemplateResponse> info(@PathVariable("templateId") Long templateId) {
        return new Response<>(convert(couponTemplateService.info(templateId)));
    }

    private DiscountCouponTemplateResponse convert(DiscountCouponTemplate template) {
        if (Objects.isNull(template)) {
            return null;
        }
        DiscountCouponTemplateResponse response = new DiscountCouponTemplateResponse();
        BeanCopier.create(template, response).copy();

        return response;
    }
}
