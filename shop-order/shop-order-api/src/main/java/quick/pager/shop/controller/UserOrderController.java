package quick.pager.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.order.request.OrderPageRequest;
import quick.pager.shop.order.request.UserOrderSaveRequest;
import quick.pager.shop.order.response.OrderResponse;
import quick.pager.shop.user.response.Response;
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

    /**
     * 用户订单列表
     */
    @PostMapping(value = "/user/orders")
    public Response<List<OrderResponse>> orders(@RequestBody OrderPageRequest request) {

        return userOrderService.queryPage(request);
    }

    /**
     * App订单详情
     */
    @RequestMapping(value = "/user/{orderId}/detail")
    public Response<Object> detail(@PathVariable("orderId") Long orderId) {
        return userOrderService.detail(orderId);
    }

    /**
     * 创建订单
     */
    @RequestMapping(value = "/user/create")
    public Response<Long> create(@RequestBody UserOrderSaveRequest request) {
        return userOrderService.create(request);
    }
}
