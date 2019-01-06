package quick.pager.shop.goods.mapper;

import quick.pager.shop.model.goods.GoodsDetail;

public interface GoodsDetailMapper {

    int insertSelective(GoodsDetail record);

    GoodsDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsDetail record);

}