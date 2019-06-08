package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.FightGroupGoods;

@Mapper
public interface FightGroupGoodsMapper {

    int insertSelective(FightGroupGoods record);

    FightGroupGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroupGoods record);

    FightGroupGoods selectFightGroupGoods(@Param("activityId") Long activityId);

    /**
     * 根据活动ID 与商品ID 查询当前活动是否存在参与的商品
     *
     * @param activityId 活动ID
     * @param goodsId    商品ID
     */
    int selectCountByActivityIdAndGoodsId(@Param("activityId") Long activityId, @Param("goodsId") Long goodsId);

}
