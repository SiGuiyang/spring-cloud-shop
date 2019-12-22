package quick.pager.shop.manage.service.activity;

import java.util.List;
import quick.pager.shop.activity.response.coupon.DiscountCouponTemplateResponse;
import quick.pager.shop.manage.param.coupon.DiscountCouponTemplatePageParam;
import quick.pager.shop.manage.param.coupon.DiscountCouponTemplateSaveParam;
import quick.pager.shop.response.Response;

/**
 * 优惠券模板
 *
 * @author siguiyang
 * @version 3.0
 */
public interface CouponTemplateService {

    /**
     * 优惠券模板列表
     */
    Response<List<DiscountCouponTemplateResponse>> template(DiscountCouponTemplatePageParam dto);

    /**
     * 修改优惠券模板
     */
    Response<Long> modify(DiscountCouponTemplateSaveParam dto);

    /**
     * 优惠券模板新增
     */
    Response<Long> create(DiscountCouponTemplateSaveParam dto);
}
