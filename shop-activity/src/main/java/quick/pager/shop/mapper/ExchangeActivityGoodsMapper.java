package quick.pager.shop.mapper;

import java.util.List;

import quick.pager.shop.model.ExchangeActivityGoods;

/**
* @author siguiyang
*/
public interface ExchangeActivityGoodsMapper {

    int insertSelective(ExchangeActivityGoods record);

    ExchangeActivityGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExchangeActivityGoods record);
    /**
     * 表格查询
     */
    List<ExchangeActivityGoods> select(ExchangeActivityGoods record);
}
