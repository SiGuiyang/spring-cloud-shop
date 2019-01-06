package quick.pager.shop.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.order.service.OrderDetailService;
import quick.pager.shop.order.service.OrderListService;
import quick.pager.shop.order.service.OrderStatusService;

/**
 * 订单管理<br />
 * <p>
 * 订单列表
 * 订单详情
 * 订单状态图
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ORDER)
public class OrderController {

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderStatusService orderStatusService;

    /**
     * 订单列表
     *
     * @param userId 用户Id
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public Response orderList(@PathVariable("userId") Long userId) {
        return null;
    }

    /**
     * 订单详情
     *
     * @param userId 用户Id
     */
    @RequestMapping(value = "/detail/{userId}", method = RequestMethod.POST)
    public Response orderDetail(@PathVariable("userId") Long userId) {
        return null;
    }

    /**
     * 订单状态图
     *
     * @param orderId 订单Id
     */
    @RequestMapping(value = "/status/{orderId}", method = RequestMethod.POST)
    public Response orderStatus(@PathVariable("orderId") Long orderId) {
        return null;
    }
}
