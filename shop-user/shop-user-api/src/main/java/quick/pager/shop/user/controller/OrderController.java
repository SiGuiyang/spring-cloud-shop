package quick.pager.shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.user.service.UserOrderService;

/**
 * 用户订单
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class OrderController {


    @Autowired
    private UserOrderService userOrderService;

    /**
     * 订单列表
     */
    @PostMapping("/orders")
    public Response orderList() {
        return userOrderService.orders();
    }

    /**
     * 订单详情
     */
    @PostMapping("/oder/detail")
    public Response detail() {
        return userOrderService.orderInfo(0L);
    }

    /**
     * 创建订单，下单接口
     */
    @PostMapping("/order/create")
    public Response createOrder() {
        return userOrderService.createOrder();
    }
}
