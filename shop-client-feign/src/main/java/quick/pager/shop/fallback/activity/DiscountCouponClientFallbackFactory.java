package quick.pager.shop.fallback.activity;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.client.activity.DiscountCouponClient;

/**
 * 优惠券服务
 *
 * @author siguiyang
 */
@Slf4j
@Component
public class DiscountCouponClientFallbackFactory implements FallbackFactory<DiscountCouponClient> {

    @Override
    public DiscountCouponClient create(Throwable cause) {
        return null;
    }
}
