package quick.pager.shop.fallback;

import feign.hystrix.FallbackFactory;
import quick.pager.shop.client.AuthClient;

public class AuthFallback implements FallbackFactory<AuthClient> {

    @Override
    public AuthClient create(Throwable cause) {
        return null;
    }
}
