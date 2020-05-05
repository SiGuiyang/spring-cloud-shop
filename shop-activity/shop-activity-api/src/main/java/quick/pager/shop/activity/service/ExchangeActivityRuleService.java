package quick.pager.shop.activity.service;

import java.util.List;
import quick.pager.shop.activity.model.ExchangeActivityRule;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRuleSaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;

/**
 * 满赠换购规则服务
 *
 * @author siguiyang
 */
public interface ExchangeActivityRuleService extends IService<ExchangeActivityRule> {

    /**
     * 根据活动主键查询此活动的规则
     *
     * @param activityId 活动主键
     */
    Response<List<ExchangeActivityRuleResponse>> queryList(Long activityId);

    /**
     * 新增
     *
     * @return 规则主键
     */
    Response<Long> create(ExchangeActivityRuleSaveRequest request);

    /**
     * 修改
     *
     * @return 规则主键
     */
    Response<Long> modify(ExchangeActivityRuleSaveRequest request);
}
