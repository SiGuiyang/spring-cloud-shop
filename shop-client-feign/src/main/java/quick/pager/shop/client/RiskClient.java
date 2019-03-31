package quick.pager.shop.client;

import org.springframework.cloud.openfeign.FeignClient;
import quick.pager.shop.fallback.RiskFallbackFactory;

@FeignClient(value = "shop-risk", path = "/risk", fallbackFactory = RiskFallbackFactory.class)
public interface RiskClient {
}
