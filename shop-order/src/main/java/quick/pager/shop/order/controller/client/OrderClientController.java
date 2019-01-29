package quick.pager.shop.order.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.request.OrderRequest;
import quick.pager.shop.feign.request.SellerOrderRequest;
import quick.pager.shop.order.service.client.OrderClientService;

/**
 * 暴露feign 服务
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ORDER)
public class OrderClientController {

    @Autowired
    private OrderClientService orderClientService;

    /**
     * 订单列表
     */
    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public Response orders(@RequestBody OrderRequest request) {

        return orderClientService.userOrder(request);
    }


    /**
     * 订单详情
     */
    @RequestMapping(value = "/orderInfo/{orderId}", method = RequestMethod.POST)
    public Response orderInfo(@PathVariable("orderId") Long orderId) {
        return orderClientService.orderInfo(orderId);
    }

    /**
     * 商户订单列表
     */
    @RequestMapping(value = "/sellerOrders", method = RequestMethod.POST)
    public Response sellerOrders(@RequestBody SellerOrderRequest request) {
        return null;
    }

    /**
     * 商户订单详情
     */
    @RequestMapping(value = "/sellerOrderInfo/{sellerOrderId}", method = RequestMethod.POST)
    public Response sellerOrderInfo(@PathVariable("sellerOrderId") Long sellerOrderId) {
        return null;
    }
}
