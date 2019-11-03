package quick.pager.shop.service;

import quick.pager.shop.dto.activity.CouponTemplateDTO;
import quick.pager.shop.model.activity.DiscountCouponTemplate;
import quick.pager.shop.response.Response;

/**
 * 优惠券模版
 *
 * @author siguiyang
 */
public interface CouponTemplateService extends IPageService<DiscountCouponTemplate> {
    /**
     * 查询优惠券模版列表
     */
    Response list(CouponTemplateDTO dto);

    /**
     * 新增或者修改优惠券模版列表
     */
    Response modify(CouponTemplateDTO couponTemplateDTO);

    /**
     * 根据主键获取优惠券模板
     */
    Response<DiscountCouponTemplate> info(Long id);
}
