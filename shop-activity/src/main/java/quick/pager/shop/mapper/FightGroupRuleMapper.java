package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.FightGroupRule;

@Mapper
public interface FightGroupRuleMapper {

    int insertSelective(FightGroupRule record);

    FightGroupRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroupRule record);

    /**
     * 根据活动Id 查询规则
     */
    FightGroupRule selectFightGroupRule(@Param("activityId") Long activityId);

}
