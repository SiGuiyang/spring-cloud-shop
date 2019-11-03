package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.AssembleActivityRule;

@Mapper
public interface AssembleActivityRuleMapper extends BaseMapper<AssembleActivityRule> {

    int insertSelective(AssembleActivityRule record);

    AssembleActivityRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AssembleActivityRule record);

    /**
     * 根据活动Id 查询规则
     */
    AssembleActivityRule selectFightGroupRule(@Param("activityId") Long activityId);

}
