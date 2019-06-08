package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.goods.GoodsCart;

@Mapper
public interface GoodsCartMapper {

    int insertSelective(GoodsCart record);

    GoodsCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsCart record);

    /**
     * 查询用户的购物车列表
     *
     * @param userId 用户Id
     */
    List<GoodsCart> selectCarts(@Param("userId") Long userId);

    /**
     * 查询用户的购物车
     *
     * @param userId  用户Id
     * @param goodsId 商品Id
     */
    List<GoodsCart> selectGoodsCarts(@Param("userId") Long userId, @Param("goodsIds") List<Long> goodsId);

    List<GoodsCart> selectByBuyCartId(@Param("buyerCartId") Long buyerCartId);

}
