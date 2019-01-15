package quick.pager.shop.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 活动fallback
 *
 * @author siguiyang
 */
@Component
public class ActivityFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        return null;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return null;
    }
}
