package quick.pager.shop.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.response.Response;
import quick.pager.shop.cart.dto.CartDTO;
import quick.pager.shop.cart.request.CartRequest;
import quick.pager.shop.cart.service.CartListService;
import quick.pager.shop.cart.service.CartModifyService;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 购物车<br />
 * 添加购物车
 * 删除购物车商品
 */
@RestController
public class CartController {

    @Autowired
    private CartListService cartListService;
    @Autowired
    private CartModifyService cartModifyService;

    /**
     * 购物车列表
     *
     * @param userId 用户Id
     */
    @RequestMapping(value = "/cart/list/{userId}", method = RequestMethod.POST)
    public Response cartList(@PathVariable("userId") Long userId) {
        return cartListService.doService(CartDTO.builder().userId(userId).build());
    }

    /**
     * 购物车商品的添加与删除
     */
    @RequestMapping("/cart/modify")
    public Response addCart(CartRequest request) {
        return null;
    }


}
