package quick.pager.shop.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.order.OrderDTO;
import quick.pager.shop.model.order.UserOrder;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.UserOrderService;

/**
 * 用户订单管理<br />
 * <p>
 * 订单列表
 * 订单详情
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ORDER)
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @ApiOperation("用户订单列表")
    @RequestMapping(value = "/user/orders", method = RequestMethod.POST)
    public Response<List<Object>> userOrderList(@RequestBody OrderDTO dto) {

        return userOrderService.userOrderList(dto);
    }

    @ApiOperation("App订单详情")
    @RequestMapping(value = "/detail/user/{orderId}", method = RequestMethod.POST)
    public Response<Object> userOrderDetail(@PathVariable("orderId") Long orderId) {
        return userOrderService.userOrderDetail(orderId);
    }

    @ApiOperation("创建订单")
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public Response orderCreate(@RequestBody UserOrder userOrder) {
        return userOrderService.orderCreate(userOrder);
    }
}
