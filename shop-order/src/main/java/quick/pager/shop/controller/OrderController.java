package quick.pager.shop.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.OrderDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.OrderDetailService;
import quick.pager.shop.service.OrderListService;
import quick.pager.shop.service.OrderStatusService;

/**
 * 订单管理<br />
 * <p>
 * 订单列表
 * 订单详情
 * 订单状态图
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ORDER)
public class OrderController {

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderStatusService orderStatusService;

    /**
     * 订单列表
     *
     * @param userId 用户Id
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "手机号码", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "order", value = "所有订单 1, 待付款 2, 待收货 3, 待自提 4, 待评价 5", required = true, dataType = "String", paramType = "query")})
    @RequestMapping(value = "/orderList/{userId}", method = RequestMethod.POST)
    public Response orderList(@PathVariable("userId") Long userId,
                              @RequestParam("order") String order,
                              @RequestParam("page") Integer page,
                              @RequestParam("pageSize") Integer pageSize) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrder(order);
        orderDTO.setUserId(userId);
        orderDTO.setPage(page);
        orderDTO.setPageSize(pageSize);
        return orderListService.doService(orderDTO);
    }

    /**
     * 订单详情
     *
     * @param userId 用户Id
     */
    @RequestMapping(value = "/detail/{userId}", method = RequestMethod.POST)
    public Response orderDetail(@PathVariable("userId") Long userId) {
        return null;
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
}
