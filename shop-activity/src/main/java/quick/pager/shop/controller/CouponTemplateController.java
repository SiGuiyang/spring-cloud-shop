package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.activity.CouponTemplateDTO;
import quick.pager.shop.model.activity.DiscountCouponTemplate;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.CouponTemplateService;

/**
 * 优惠券模板管理
 */
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
public class CouponTemplateController {


    @Autowired
    private CouponTemplateService couponTemplateService;

    /**
     * 优惠券模板列表
     */
    @PostMapping("/coupon/template/list")
    public Response template(@RequestBody CouponTemplateDTO dto) {
        return couponTemplateService.list(dto);
    }

    /**
     * 优惠券模板新增
     */
    @PostMapping("/coupon/template/create")
    public Response create(@RequestBody CouponTemplateDTO dto) {
        return couponTemplateService.modify(dto);
    }

    /**
     * 优惠券模板修改
     */
    @PutMapping("/coupon/template/modify")
    public Response modify(@RequestBody CouponTemplateDTO dto) {
        return couponTemplateService.modify(dto);
    }

    /**
     * 获取优惠券模板信息
     */
    @GetMapping("/coupon/template/{templateId}")
    public Response<DiscountCouponTemplate> templateInfo(@PathVariable("templateId") Long templateId) {
        return new Response<>(couponTemplateService.getById(templateId));
    }
}
