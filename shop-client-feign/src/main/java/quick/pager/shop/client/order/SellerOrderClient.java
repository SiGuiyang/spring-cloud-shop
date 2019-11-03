package quick.pager.shop.client.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.dto.order.SellerOrderDTO;
import quick.pager.shop.fallback.order.SellerOrderClientFallbackFactory;
import quick.pager.shop.model.order.SellerOrder;
import quick.pager.shop.response.Response;

/**
 * 商户订单模块
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ORDER_CLIENT, path = ConstantsClient.ORDER, fallbackFactory = SellerOrderClientFallbackFactory.class)
public interface SellerOrderClient {

    /**
     * 商户订单列表
     */
    @RequestMapping(value = "/seller/orders", method = RequestMethod.POST)
    Response sellerOrders(@RequestBody SellerOrderDTO request);

    /**
     * 商户订单详情
     */
    @RequestMapping(value = "/seller/{sellerOrderId}/order", method = RequestMethod.POST)
    Response sellerOrderInfo(@PathVariable("sellerOrderId") Long sellerOrderId);

    /**
     * 创建商户订单
     *
     * @param sellerOrder 订单
     */
    @RequestMapping(value = "/seller/create", method = RequestMethod.POST)
    Response sellerOrderCreate(@RequestBody SellerOrder sellerOrder);
}
