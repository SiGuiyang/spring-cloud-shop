package quick.pager.shop.cart.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import quick.pager.shop.cart.client.CartClient;

@Component
public class CartFallbackFactory implements FallbackFactory<CartClient> {
    @Override
    public CartClient create(Throwable cause) {
        return null;
    }
}
