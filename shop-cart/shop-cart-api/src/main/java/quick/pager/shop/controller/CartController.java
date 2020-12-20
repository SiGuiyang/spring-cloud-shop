package quick.pager.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.cart.request.CartOtherRequest;
import quick.pager.shop.cart.request.CartRequest;
import quick.pager.shop.cart.response.GoodsCartResponse;
import quick.pager.shop.service.CartService;
import quick.pager.shop.constants.ConstantsClient;
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
    @PostMapping("/app/user/{userId}/{page}/page")
    public Response<List<GoodsCartResponse>> page(@PathVariable("userId") Long userId, @PathVariable("page") Integer page) {

        return cartService.page(userId, page);
    }


    /**
     * 用户购物车列表信息
     *
     * @param request 请求参数
     */
    @PostMapping("/app/user/list")
    public Response<List<GoodsCartResponse>> list(@RequestBody CartOtherRequest request) {

        return cartService.list(request);
    }

    /**
     * 购物车添加
     *
     * @param request 请求参数
     * @return 主键
     */
    @PostMapping("/app/cart/create")
    public Response<Long> create(@RequestBody CartRequest request) {

        return cartService.create(request);
    }


    /**
     * 购物车删除
     *
     * @param id 购物车主键
     * @return 主键
     */
    @PostMapping("/app/cart/delete/{id}")
    public Response<Long> delete(@PathVariable Long id) {

        return cartService.delete(id);
    }

    /**
     * 购物车批量删除
     *
     * @param ids 购物车主键
     * @return 主键
     */
    @PostMapping("/app/cart/delete/batch")
    public Response<List<Long>> deleteBatch(@RequestBody List<Long> ids) {

        return cartService.deleteBatch(ids);
    }
}
