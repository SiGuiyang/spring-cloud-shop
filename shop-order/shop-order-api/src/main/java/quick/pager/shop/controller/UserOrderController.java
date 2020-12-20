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
import quick.pager.shop.order.response.UserOrderResponse;
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
     *
     * @param request 请求参数
     */
    @PostMapping(value = "/user/page")
    public Response<List<UserOrderResponse>> page(@RequestBody OrderPageRequest request) {

        return userOrderService.queryPage(request);
    }

    /**
     * App订单详情
     *
     * @param orderId 订单主键
     */
    @RequestMapping(value = "/user/{orderId}/detail")
    public Response<Object> detail(@PathVariable("orderId") Long orderId) {
        return userOrderService.detail(orderId);
    }
}
