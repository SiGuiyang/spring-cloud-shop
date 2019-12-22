package quick.pager.shop.activity.service;

import java.util.List;
import quick.pager.shop.activity.model.DiscountCouponTemplate;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplatePageRequest;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplateSaveRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IPageService;

/**
 * 优惠券模版
 *
 * @author siguiyang
 */
public interface CouponTemplateService extends IPageService<DiscountCouponTemplate> {
    /**
     * 查询优惠券模版列表
     */
    Response<List<DiscountCouponTemplate>> list(DiscountCouponTemplatePageRequest request);

    /**
     * 新增或者修改优惠券模版列表
     */
    Response<Long> modify(DiscountCouponTemplateSaveRequest request);

    /**
     * 根据主键获取优惠券模板
     */
    Response<DiscountCouponTemplate> info(Long id);
}
