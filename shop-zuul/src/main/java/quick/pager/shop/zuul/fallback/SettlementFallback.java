package quick.pager.shop.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 清结算fallback
 *
 * @author siguiyang
 */
@Component
public class SettlementFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        return "shop-settlement";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return null;
    }
}
