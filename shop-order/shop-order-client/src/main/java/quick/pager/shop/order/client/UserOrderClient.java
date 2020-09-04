package quick.pager.shop.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.order.fallback.UserOrderClientFallbackFactory;
import quick.pager.shop.order.request.OrderPageRequest;
import quick.pager.shop.order.request.UserOrderSaveRequest;
import quick.pager.shop.user.response.Response;

/**
 * 用户订单
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ORDER_CLIENT, path = ConstantsClient.ORDER, fallbackFactory = UserOrderClientFallbackFactory.class)
public interface UserOrderClient {

    /**
     * 订单列表
     *
     * @param request 请求参数
     * @return 订单列表
     */
    @RequestMapping(value = "/user/orders", method = RequestMethod.POST)
    Response orders(@RequestBody OrderPageRequest request);

    /**
     * 订单详情
     *
     * @param orderId 订单主键
     * @return 订单详情
     */
    @RequestMapping(value = "/user/{orderId}/detail", method = RequestMethod.POST)
    Response orderInfo(@PathVariable("orderId") Long orderId);

    /**
     * 创建用户订单
     *
     * @param request 订单
     * @return 订单主键
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody UserOrderSaveRequest request);
}
