package quick.pager.shop.activity.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.activity.client.DiscountCouponClient;

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
