package quick.pager.shop.controller;

import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.cart.request.OrderCartSaveRequest;
import quick.pager.shop.cart.response.OrderCartResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.service.OrderCartService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;

/**
 * 订单购物车
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.CART)
public class OrderCartController {

    @Autowired
    private OrderCartService orderCartService;

    /**
     * 订单购物车
     *
     * @param request 请求参数
     */
    @PostMapping("/app/orders/create")
    public Response<OrderCartResponse> create(@RequestBody OrderCartSaveRequest request) {

        Assert.isTrue(CollectionUtils.isNotEmpty(request.getOrderCarts()), () -> "购物车商品不存在");
        Assert.isTrue(Objects.nonNull(request.getUserId()), () -> "用户不存在");
        Assert.isTrue(Objects.nonNull(request.getSellerId()), () -> "商户不存在");
        Assert.isTrue(Objects.nonNull(request.getUserOrderId()), () -> "用户订单不存在");
        Assert.isTrue(Objects.nonNull(request.getSellerOrderId()), () -> "商户订单不存在");
        return orderCartService.orders(request);

    }
}
