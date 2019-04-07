package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.GoodsDetail;

public interface GoodsDetailMapper {

    int insertSelective(GoodsDetail record);

    GoodsDetail selectByPrimaryKey(Long id);

    GoodsDetail selectByGoodsId(@Param("goodsId") Long goodsId);

    int updateByPrimaryKeySelective(GoodsDetail record);

}
