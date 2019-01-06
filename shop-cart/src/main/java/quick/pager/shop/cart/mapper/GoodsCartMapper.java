package quick.pager.shop.cart.mapper;

import quick.pager.shop.model.cart.GoodsCart;

public interface GoodsCartMapper {

    int insertSelective(GoodsCart record);

    GoodsCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsCart record);

}