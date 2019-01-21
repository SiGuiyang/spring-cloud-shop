package quick.pager.shop.manage.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.fallback.OrderClientFallbackFactory;
import quick.pager.shop.model.feign.request.OrderRequest;
import quick.pager.shop.model.feign.request.SellerOrderRequest;

/**
 * 订单模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-order", fallbackFactory = OrderClientFallbackFactory.class)
public interface OrderClient {

    /**
     * 订单列表
     */
    @RequestMapping(value = "/order/orders", method = RequestMethod.POST)
    Response orders(@RequestBody OrderRequest request);

    /**
     * 订单详情
     */
    @RequestMapping(value = "/order/orderInfo/{orderId}", method = RequestMethod.POST)
    Response orderInfo(@PathVariable("orderId") Long orderId);

    /**
     * 商户订单列表
     */
    @RequestMapping(value = "/order/sellerOrders", method = RequestMethod.POST)
    Response sellerOrders(@RequestBody SellerOrderRequest request);

    /**
     * 商户订单详情
     */
    @RequestMapping(value = "/order/sellerOrderInfo/{sellerOrderId}", method = RequestMethod.POST)
    Response sellerOrderInfo(@PathVariable("sellerOrderId") Long sellerOrderId);
}
