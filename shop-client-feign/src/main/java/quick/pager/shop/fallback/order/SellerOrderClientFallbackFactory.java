package quick.pager.shop.fallback.order;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.client.order.SellerOrderClient;

@Slf4j
@Component
public class SellerOrderClientFallbackFactory implements FallbackFactory<SellerOrderClient> {
    @Override
    public SellerOrderClient create(Throwable cause) {
        return null;
    }
}
