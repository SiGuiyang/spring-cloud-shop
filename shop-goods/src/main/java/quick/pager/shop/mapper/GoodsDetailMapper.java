package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.goods.GoodsDetail;

@Mapper
public interface GoodsDetailMapper {

    int insertSelective(GoodsDetail record);

    GoodsDetail selectByPrimaryKey(Long id);

    GoodsDetail selectByGoodsId(@Param("goodsId") Long goodsId);

    int updateByPrimaryKeySelective(GoodsDetail record);

}
