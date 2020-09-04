package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.param.CartParam;
import quick.pager.shop.cart.response.GoodsCartResponse;
import quick.pager.shop.user.response.Response;

/**
 * 购物车
 *
 * @author siguiyang
 */
public interface CartService {
    /**
     * 购物车列表
     *
     * @param userId 当前登陆人主键
     * @param page   页码
     */
    Response<List<GoodsCartResponse>> list(final Long userId, final Integer page);

    /**
     * 添加修改购物车
     * 1. 商品未添加购物车时，直接生产购物车数据
     * 2. 商品已添加购物车时
     * 添加相同的商品，修改购物车的数量
     * 3. 减少购物车购买的数量
     * 购物车数量减少
     * <p>
     * 针对商品数量时，前端传入的数量值为最新的购买数量
     * </p>
     *
     * @param param 参数
     */
    Response<String> add(final CartParam param);

    /**
     * 删除购物车
     *
     * @param ids 购物车主键集
     */
    Response<String> delete(final List<Long> ids);
}
