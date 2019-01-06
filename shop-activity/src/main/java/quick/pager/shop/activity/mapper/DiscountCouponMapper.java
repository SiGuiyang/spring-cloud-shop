package quick.pager.shop.activity.mapper;

import quick.pager.shop.model.activity.DiscountCoupon;

public interface DiscountCouponMapper {

    int insertSelective(DiscountCoupon record);

    DiscountCoupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DiscountCoupon record);

}