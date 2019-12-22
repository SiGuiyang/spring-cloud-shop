package quick.pager.shop.order.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.order.client.SellerOrderClient;

@Slf4j
@Component
public class SellerOrderClientFallbackFactory implements FallbackFactory<SellerOrderClient> {
    @Override
    public SellerOrderClient create(Throwable cause) {
        return null;
    }
}
