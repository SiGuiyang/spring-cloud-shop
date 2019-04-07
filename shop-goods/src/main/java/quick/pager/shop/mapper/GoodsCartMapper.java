package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.GoodsCart;

public interface GoodsCartMapper {

    int insertSelective(GoodsCart record);

    GoodsCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsCart record);

    /**
     * 查询用户的购物车列表
     */
    List<GoodsCart> selectCarts(@Param("userId") Long userId);

    List<GoodsCart> selectByBuyCartId(@Param("buyerCartId") Long buyerCartId);

}
