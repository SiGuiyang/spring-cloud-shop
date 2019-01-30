package quick.pager.shop.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import quick.pager.shop.feign.fallback.RiskFallbackFactory;

@FeignClient(value = "shop-risk", path = "/risk", fallbackFactory = RiskFallbackFactory.class)
public interface RiskClient {
}
