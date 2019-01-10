package quick.pager.shop.manage.client;

import org.springframework.cloud.openfeign.FeignClient;
import quick.pager.shop.manage.fallback.SellerClientFallback;

/**
 * 商家模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-seller",fallback = SellerClientFallback.class)
public interface SellerClient {
}
