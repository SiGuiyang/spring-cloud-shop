package quick.pager.shop.feign.fallback;

import feign.hystrix.FallbackFactory;
import quick.pager.shop.feign.client.AuthClient;

public class AuthFallback implements FallbackFactory<AuthClient> {

    @Override
    public AuthClient create(Throwable cause) {
        return null;
    }
}
