package quick.pager.shop.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;

/**
 * 用户订单
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class UserOrderController {

    /**
     * 订单气泡数
     */
    @PostMapping("/order/badge/{userId}")
    public Response userOrderBadge(@PathVariable("userId") Long userId) {
        return null;
    }

    /**
     * 订单列表
     */
    @PostMapping("/order")
    public Response userOrders() {
        return null;
    }

    /**
     * 订单详情
     */
    @PostMapping("/orderId")
    public Response userOrderInfo(@PathVariable("orderId") Long orderId) {
        return null;
    }
}
