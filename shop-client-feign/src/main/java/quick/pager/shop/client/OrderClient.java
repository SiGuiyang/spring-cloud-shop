package quick.pager.shop.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.OrderDTO;
import quick.pager.shop.dto.SellerOrderDTO;
import quick.pager.shop.fallback.OrderClientFallbackFactory;
import quick.pager.shop.model.order.SellerOrder;
import quick.pager.shop.model.order.UserOrder;
import quick.pager.shop.response.Response;

/**
 * 订单模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-order", path = Constants.Module.ORDER, fallbackFactory = OrderClientFallbackFactory.class)
public interface OrderClient {

    /**
     * 订单列表
     */
    @RequestMapping(value = "/user/orders", method = RequestMethod.POST)
    Response orders(@RequestBody OrderDTO request);

    /**
     * 订单详情
     */
    @RequestMapping(value = "/detail/user/{orderId}", method = RequestMethod.POST)
    Response orderInfo(@PathVariable("orderId") Long orderId);

    /**
     * 商户订单列表
     */
    @RequestMapping(value = "/seller/orders", method = RequestMethod.POST)
    Response sellerOrders(@RequestBody SellerOrderDTO request);

    /**
     * 商户订单详情
     */
    @RequestMapping(value = "/seller/order/{sellerOrderId}", method = RequestMethod.POST)
    Response sellerOrderInfo(@PathVariable("sellerOrderId") Long sellerOrderId);

    /**
     * 创建用户订单
     *
     * @param userOrder 订单
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    Response userOrderCreate(@RequestBody UserOrder userOrder);


    /**
     * 创建商户订单
     *
     * @param sellerOrder 订单
     */
    @RequestMapping(value = "/seller/create", method = RequestMethod.POST)
    Response sellerOrderCreate(@RequestBody SellerOrder sellerOrder);
}
