package quick.pager.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.ExchangeActivityRule;

/**
* @author siguiyang
*/
@Mapper
public interface ExchangeActivityRuleMapper {

    int insertSelective(ExchangeActivityRule record);

    ExchangeActivityRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExchangeActivityRule record);
    /**
     * 表格查询
     */
    List<ExchangeActivityRule> select(@Param("activityId") Long activityId);
}
