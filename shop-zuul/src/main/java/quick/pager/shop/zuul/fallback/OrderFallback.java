package quick.pager.shop.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 订单fallback
 *
 * @author siguiyang
 */
@Component
public class OrderFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        return "shop-order";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return null;
    }
}
