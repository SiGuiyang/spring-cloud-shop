package quick.pager.shop.service;

import quick.pager.shop.dto.GoodsCartDTO;
import quick.pager.shop.response.Response;

public interface GoodsCartService {
    /**
     * 购物车列表
     */
    Response goodsCarts(GoodsCartDTO dto);

    /**
     * 添加 | 删除 购物车
     */
    Response modifyGoodsCart(GoodsCartDTO dto);
}
