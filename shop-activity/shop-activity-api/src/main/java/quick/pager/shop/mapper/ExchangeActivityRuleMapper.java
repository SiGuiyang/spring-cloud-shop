package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import quick.pager.shop.model.ExchangeActivityRule;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;

/**
 * 满赠换购规则Mapper
 *
 * @author siguiyang
 */
@Mapper
public interface ExchangeActivityRuleMapper extends BaseMapper<ExchangeActivityRule> {
    /**
     * 表格查询
     *
     * @param activityId 活动主键
     * @return 满赠换购规则列表
     */
    @Select("select r.id as id, r.activity_id as activityId, r.rule_name as ruleName, r.order_amount as orderAmount, "
            + "r.update_time as updateTime, r.create_time as createTime, r.delete_status as deleteStatus, ac.activity_name as activityName "
            + "from t_exchange_activity_rule r left join t_exchange_activity ac on r.activity_id = ac.id "
            + "where r.activity_id = #{activityId}")
    List<ExchangeActivityRuleResponse> selectByActivityId(@Param("activityId") Long activityId);
}
