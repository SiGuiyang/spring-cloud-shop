package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.activity.ExchangeActivityGoods;

/**
* @author siguiyang
*/
@Mapper
public interface ExchangeActivityGoodsMapper {

    int insertSelective(ExchangeActivityGoods record);

    ExchangeActivityGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExchangeActivityGoods record);
    /**
     * 表格查询
     */
    ExchangeActivityGoods select(ExchangeActivityGoods record);
}
