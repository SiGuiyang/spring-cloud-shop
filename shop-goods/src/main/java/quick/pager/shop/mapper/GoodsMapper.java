package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.goods.Goods;

@Mapper
public interface GoodsMapper {

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);


    /**
     * 获取上架状态的商品
     */
    List<Goods> selectShelfGoods();

    /**
     * 根据商品分类查询商品
     *
     * @param goodsClassId 商品分类Id
     */
    List<Goods> selectByGoodsClassId(@Param("goodsClassId") Long goodsClassId, @Param("page") Integer page, @Param("pageSize") Integer pageSize);

    /**
     * 根据商品名称模糊搜索
     *
     * @param goodsName 商品名称
     */
    List<Goods> selectByGoodsName(@Param("goodsName") String goodsName);

    List<Goods> queryGoodsList(@Param("goodsName") String goodsName, @Param("goodsStatus") Integer goodsStatus, @Param("goodsType") Integer goodsType, @Param("gcsId") Long gcsId);
}
