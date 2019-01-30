package quick.pager.shop.feign.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import quick.pager.shop.feign.client.RiskClient;

/**
 * 风控服务熔断
 *
 * @author siguiyang
 */
@Component
public class RiskFallbackFactory implements FallbackFactory<RiskClient> {
    @Override
    public RiskClient create(Throwable cause) {
        return null;
    }
}
