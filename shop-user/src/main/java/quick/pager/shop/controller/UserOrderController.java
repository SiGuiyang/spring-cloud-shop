package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;

@Api(description = "用户订单")
@RestController
@RequestMapping(Constants.Module.USER)
public class UserOrderController {


    @ApiOperation("订单气泡数")
    @PostMapping("/order/badge/{userId}")
    public Response userOrderBadge(@PathVariable("userId") Long userId) {
        return null;
    }

    @ApiOperation("订单列表")
    @PostMapping("/order")
    public Response userOrders() {
        return null;
    }
    
    @ApiOperation("订单详情")
    @PostMapping("/orderId")
    public Response userOrderInfo(@PathVariable("orderId") Long orderId) {
        return null;
    }
}
