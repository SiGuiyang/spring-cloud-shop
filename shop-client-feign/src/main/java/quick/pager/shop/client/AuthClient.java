package quick.pager.shop.client;

import org.springframework.cloud.openfeign.FeignClient;
import quick.pager.shop.fallback.AuthFallback;

/**
 * 授权
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-auth", fallbackFactory = AuthFallback.class)
public interface AuthClient {
}
