package quick.pager.shop.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.order.fallback.UserOrderClientFallbackFactory;
import quick.pager.shop.order.request.OrderRequest;
import quick.pager.shop.order.request.UserOrderSaveRequest;
import quick.pager.shop.response.Response;

/**
 * 用户订单
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ORDER_CLIENT, path = ConstantsClient.ORDER, fallbackFactory = UserOrderClientFallbackFactory.class)
public interface UserOrderClient {

    /**
     * 订单列表
     */
    @RequestMapping(value = "/user/orders", method = RequestMethod.POST)
    Response orders(@RequestBody OrderRequest request);

    /**
     * 订单详情
     */
    @RequestMapping(value = "/detail/{orderId}/user", method = RequestMethod.POST)
    Response orderInfo(@PathVariable("orderId") Long orderId);

    /**
     * 创建用户订单
     *
     * @param request 订单
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    Response userOrderCreate(@RequestBody UserOrderSaveRequest request);
}
