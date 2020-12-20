package quick.pager.shop.cart.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.cart.fallback.CartFallbackFactory;
import quick.pager.shop.cart.request.OrderCartSaveRequest;
import quick.pager.shop.cart.response.GoodsCartResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

/**
 * 订单商品购物车
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.CART_CLIENT, path = ConstantsClient.CART, fallbackFactory = CartFallbackFactory.class)
public interface OrderCartClient {


    /**
     * 订单商品购物车
     *
     * @param request 请求参数
     */
    @RequestMapping(value = "/app/orders/create", method = RequestMethod.POST)
    Response<List<GoodsCartResponse>> create(@RequestBody OrderCartSaveRequest request);
}
