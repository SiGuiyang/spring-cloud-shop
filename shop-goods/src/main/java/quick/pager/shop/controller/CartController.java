package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.CartDTO;
import quick.pager.shop.service.CartListService;
import quick.pager.shop.service.CartModifyService;

/**
 * 购物车<br />
 * 添加购物车
 * 删除购物车商品
 */
@Api(description = "购物车")
@RestController
@RequestMapping(Constants.Module.GOODS)
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
    @ApiOperation("购物车列表")
    @RequestMapping(value = "/cart/list/{userId}", method = RequestMethod.POST)
    public Response cartList(@PathVariable("userId") Long userId) {
        CartDTO dto = new CartDTO();
        dto.setUserId(userId);

        return cartListService.doService(dto);
    }

    /**
     * 购物车商品的添加与删除
     */
    @ApiOperation("购物车商品的添加与删除")
    @RequestMapping(value = "/cart/modify", method = RequestMethod.POST)
    public Response addCart(CartDTO dto) {

        return cartModifyService.doService(dto);
    }


}
