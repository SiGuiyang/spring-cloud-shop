package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.AssembleActivityGoods;

@Mapper
public interface AssembleActivityGoodsMapper extends BaseMapper<AssembleActivityGoods> {

    int insertSelective(AssembleActivityGoods record);

    AssembleActivityGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AssembleActivityGoods record);

    AssembleActivityGoods selectFightGroupGoods(@Param("activityId") Long activityId);

    /**
     * 根据活动ID 与商品ID 查询当前活动是否存在参与的商品
     *
     * @param activityId 活动ID
     * @param goodsId    商品ID
     */
    int selectCountByActivityIdAndGoodsId(@Param("activityId") Long activityId, @Param("goodsId") Long goodsId);

}
