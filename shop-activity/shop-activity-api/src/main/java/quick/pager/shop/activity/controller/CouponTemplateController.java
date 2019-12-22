package quick.pager.shop.activity.controller;

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
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.CouponTemplateService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;

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
    @PostMapping("/coupon/template/list")
    public Response<List<DiscountCouponTemplateResponse>> templateList(@RequestBody DiscountCouponTemplatePageRequest request) {
        Response<List<DiscountCouponTemplate>> response = couponTemplateService.list(request);

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
        return couponTemplateService.modify(request);
    }

    /**
     * 优惠券模板修改
     */
    @PutMapping("/coupon/template/modify")
    public Response<Long> modify(@RequestBody DiscountCouponTemplateSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return couponTemplateService.modify(request);
    }

    /**
     * 获取优惠券模板信息
     */
    @GetMapping("/coupon/template/{templateId}")
    public Response<DiscountCouponTemplateResponse> templateInfo(@PathVariable("templateId") Long templateId) {
        return new Response<>(convert(couponTemplateService.getById(templateId)));
    }

    private DiscountCouponTemplateResponse convert(DiscountCouponTemplate template) {
        DiscountCouponTemplateResponse response = new DiscountCouponTemplateResponse();
        BeanCopier.create(template, response).copy();

        return response;
    }
}
