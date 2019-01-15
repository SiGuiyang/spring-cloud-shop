package quick.pager.shop.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 管理后台fallback
 *
 * @author siguiyang
 */
@Component
public class ManageFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        return "shop-manage";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return null;
    }
}
