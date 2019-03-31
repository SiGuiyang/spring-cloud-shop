package quick.pager.shop.controller.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.client.OrderClient;
import quick.pager.shop.dto.OrderDTO;

/**
 * 用户订单管理
 *
 * @author siguiyang
 */
@Api(description = "用户订单管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class UserOrderManageController {

    @Autowired
    private OrderClient orderClient;

    @ApiOperation("用户订单列表")
    @PostMapping("/order/user")
    public Response order(OrderDTO request) {
        return orderClient.orders(request);
    }

    @ApiOperation("用户订单详情")
    @PostMapping("/order/user/info")
    public Response orderInfo(@RequestParam("orderId") Long orderId) {
        return orderClient.orderInfo(orderId);
    }
}
