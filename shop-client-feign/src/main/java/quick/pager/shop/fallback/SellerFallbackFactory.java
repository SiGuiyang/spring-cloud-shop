package quick.pager.shop.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import quick.pager.shop.client.SellerClient;

@Component
public class SellerFallbackFactory implements FallbackFactory<SellerClient> {
    @Override
    public SellerClient create(Throwable cause) {
        return null;
    }
}
