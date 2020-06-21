package quick.pager.shop.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.cart.service.CartService;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.response.Response;

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
    public Response list(@PathVariable("userId") Long userId, @PathVariable("page") Integer page) {

        return null;
    }

    /**
     * 添加购物车
     *
     * @return
     */
    @PostMapping("/app/user/add")
    public Response add(@PathVariable("userId") Long userId, @PathVariable("skuId") Long skuId) {

        return null;
    }

    /**
     * 删除购物车
     *
     * @return
     */
    @PostMapping("/app/user/delete")
    public Response delete() {

        return null;
    }

}
