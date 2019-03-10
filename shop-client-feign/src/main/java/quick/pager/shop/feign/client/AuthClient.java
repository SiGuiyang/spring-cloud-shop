package quick.pager.shop.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import quick.pager.shop.feign.fallback.AuthFallback;

/**
 * 授权
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-auth", fallbackFactory = AuthFallback.class)
public interface AuthClient {
}
