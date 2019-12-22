package quick.pager.shop.order.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.order.client.UserOrderClient;

@Slf4j
@Component
public class UserOrderClientFallbackFactory implements FallbackFactory<UserOrderClient> {
    @Override
    public UserOrderClient create(Throwable cause) {
        return null;
    }
}
