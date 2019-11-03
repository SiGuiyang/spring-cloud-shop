package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.order.OrderDTO;
import quick.pager.shop.dto.UserOrderDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.UserOrderService;

/**
 * @author siguiyang
 */
@Api(description = "用户订单")
@RestController
@RequestMapping(Constants.Module.USER)
public class OrderController {


    @Autowired
    private UserOrderService userOrderService;

    @ApiOperation("订单列表")
    @PostMapping("/orders")
    public Response orderList(@RequestBody OrderDTO dto) {
        return userOrderService.orders(dto);
    }

    @ApiOperation("订单详情")
    @PostMapping("/oder/detail")
    public Response detail(@RequestBody OrderDTO dto) {
        return userOrderService.orderInfo(dto.getOrderId());
    }

    @ApiOperation("创建订单，下单接口")
    @PostMapping("/order/create")
    public Response createOrder(@RequestBody UserOrderDTO dto) {
        return userOrderService.createOrder(dto);
    }
}
