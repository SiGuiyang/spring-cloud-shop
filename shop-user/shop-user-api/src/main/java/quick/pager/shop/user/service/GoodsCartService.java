package quick.pager.shop.user.service;

import quick.pager.shop.response.Response;

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
