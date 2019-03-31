package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.FightGroupGoods;

public interface FightGroupGoodsMapper {

    int insertSelective(FightGroupGoods record);

    FightGroupGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroupGoods record);

    FightGroupGoods selectFightGroupGoods(@Param("groupId") Long groupId);
}