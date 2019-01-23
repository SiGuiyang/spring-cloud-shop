package quick.pager.shop.activity.mapper;

import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.FightGroupRule;

public interface FightGroupRuleMapper {

    int insertSelective(FightGroupRule record);

    FightGroupRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroupRule record);

    /**
     * 根据活动Id 查询规则
     */
    FightGroupRule selectFightGroupRule(@Param("groupId") Long groupId);

}