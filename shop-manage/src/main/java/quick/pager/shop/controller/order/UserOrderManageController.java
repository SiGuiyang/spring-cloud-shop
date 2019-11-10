package quick.pager.shop.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.client.order.UserOrderClient;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.order.OrderDTO;

/**
 * 用户订单管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class UserOrderManageController {

    @Autowired
    private UserOrderClient userOrderClient;

    /**
     * 用户订单列表
     */
    @PostMapping("/order/user")
    public Response order(@RequestBody OrderDTO request) {
        return userOrderClient.orders(request);
    }

    /**
     * 用户订单详情
     */
    @PostMapping("/order/user/info")
    public Response orderInfo(@RequestParam("orderId") Long orderId) {
        return userOrderClient.orderInfo(orderId);
    }
}
