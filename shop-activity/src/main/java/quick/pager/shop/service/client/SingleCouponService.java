package quick.pager.shop.service.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.DiscountCouponMapper;
import quick.pager.shop.model.activity.DiscountCoupon;

@Service
@Slf4j
public class SingleCouponService {

    @Autowired
    private DiscountCouponMapper discountCouponMapper;

    public DiscountCoupon getCoupons(Long couponIds) {

        return discountCouponMapper.selectByPrimaryKey(couponIds);
    }
}
