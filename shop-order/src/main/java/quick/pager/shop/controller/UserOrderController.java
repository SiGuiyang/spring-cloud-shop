package quick.pager.shop.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.OrderDTO;
import quick.pager.shop.model.UserOrder;
import quick.pager.shop.response.OrderResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.UserOrderService;

/**
 * 用户订单管理<br />
 * <p>
 * 订单列表
 * 订单详情
 * 订单状态图
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ORDER)
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @ApiOperation("用户订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "order", value = "所有订单 1, 待付款 2, 待收货 3, 待自提 4, 待评价 5", required = true, dataType = "String", paramType = "query")})
    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    public Response<List<OrderResponse>> userOrderList(@RequestBody OrderDTO dto) {

        return userOrderService.userOrderList(dto);
    }

    /**
     * 订单详情
     *
     * @param orderId 用户Id
     */
    @RequestMapping(value = "/detail/user/{orderId}", method = RequestMethod.POST)
    public Response<OrderResponse> userOrderDetail(@PathVariable("orderId") Long orderId) {
        return userOrderService.userOrderDetail(orderId);
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

    /**
     * 创建订单
     * @param userOrder 订单
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public Response orderCreate(@RequestBody UserOrder userOrder) {
        return userOrderService.orderCreate(userOrder);
    }
}
