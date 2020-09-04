package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplatePageRequest;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplateSaveRequest;
import quick.pager.shop.activity.response.coupon.DiscountCouponTemplateResponse;
import quick.pager.shop.user.response.Response;

/**
 * 优惠券模版
 *
 * @author siguiyang
 */
public interface CouponTemplateService {
    /**
     * 查询优惠券模版列表
     */
    Response<List<DiscountCouponTemplateResponse>> queryPage(DiscountCouponTemplatePageRequest request);

    /**
     * 新增优惠券模版
     */
    Response<Long> create(DiscountCouponTemplateSaveRequest request);

    /**
     * 修改优惠券模版
     */
    Response<Long> modify(DiscountCouponTemplateSaveRequest request);

    /**
     * 根据主键获取优惠券模板
     */
    DiscountCouponTemplateResponse info(Long id);
}
