package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;
import quick.pager.shop.response.ExchangeActivityRuleResponse;
import quick.pager.shop.response.Response;

/**
 * 满赠换购规则服务
 *
 * @author siguiyang
 */
public interface ExchangeActivityRuleService {

    /**
     * 根据活动主键查询此活动的规则
     *
     * @param activityId 活动主键
     */
    Response<List<ExchangeActivityRuleResponse>> rules(Long activityId);

    /**
     * 新增或者修改
     */
    Response createOrModifyRule(ExchangeActivityDTO dto);
}
