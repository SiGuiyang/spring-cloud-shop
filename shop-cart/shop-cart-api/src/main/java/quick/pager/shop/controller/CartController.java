package quick.pager.shop.controller;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.param.CartParam;
import quick.pager.shop.cart.response.GoodsCartResponse;
import quick.pager.shop.service.CartService;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;

/**
 * 购物车
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.CART)
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 用户购物车列表
     *
     * @param userId 用户主键
     * @param page   页码
     */
    @PostMapping("/app/user/{userId}/{page}/list")
    public Response<List<GoodsCartResponse>> list(@PathVariable("userId") Long userId, @PathVariable("page") Integer page) {

        return cartService.list(userId, page);
    }

    /**
     * 添加购物车
     */
    @PostMapping("/app/user/add")
    public Response<String> add(@RequestBody CartParam param) {

        return cartService.add(param);
    }

    /**
     * 删除购物车
     */
    @PostMapping("/app/user/delete")
    public Response<String> delete(@RequestBody CartParam param) {

        if (CollectionUtils.isEmpty(param.getIds())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return cartService.delete(param.getIds());
    }

}
