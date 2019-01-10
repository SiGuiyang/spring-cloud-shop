package quick.pager.shop.manage.client;

import org.springframework.cloud.openfeign.FeignClient;
import quick.pager.shop.manage.fallback.OrderClientFallback;

/**
 * 订单模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-order",fallback = OrderClientFallback.class)
public interface OrderClient {
}
