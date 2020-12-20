package quick.pager.shop.cart.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.cart.fallback.CartFallbackFactory;
import quick.pager.shop.cart.request.CartOtherRequest;
import quick.pager.shop.cart.response.GoodsCartResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

/**
 * 购物车服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.CART_CLIENT, path = ConstantsClient.CART, fallbackFactory = CartFallbackFactory.class)
public interface CartClient {


    /**
     * 用户购物车列表信息
     *
     * @param request 请求参数
     */
    @RequestMapping(value = "/app/user/list", method = RequestMethod.POST)
    Response<List<GoodsCartResponse>> list(@RequestBody CartOtherRequest request);
}
