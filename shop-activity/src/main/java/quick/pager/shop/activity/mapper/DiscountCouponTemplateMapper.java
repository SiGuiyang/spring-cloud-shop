package quick.pager.shop.activity.mapper;

import quick.pager.shop.model.activity.DiscountCouponTemplate;

public interface DiscountCouponTemplateMapper {

    int insertSelective(DiscountCouponTemplate record);

    DiscountCouponTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DiscountCouponTemplate record);

}