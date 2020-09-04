package quick.pager.shop.service;

import quick.pager.shop.user.response.Response;

public interface GoodsCartService {
    /**
     * 购物车列表
     */
    Response goodsCarts();

    /**
     * 添加 | 删除 购物车
     */
    Response modifyGoodsCart();
}
