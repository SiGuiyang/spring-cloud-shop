package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.ExchangeActivityRule;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRuleSaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.user.response.Response;

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
    Response<List<ExchangeActivityRuleResponse>> queryList(final Long activityId);

    /**
     * 新增
     *
     * @return 规则主键
     */
    Response<Long> create(final ExchangeActivityRuleSaveRequest request);

    /**
     * 修改
     *
     * @return 规则主键
     */
    Response<Long> modify(final ExchangeActivityRuleSaveRequest request);

    /**
     * 删除规则
     *
     * @param id         规则主键
     * @param activityId 活动主键
     * @return 规则主键
     */
    Response<Long> delete(final Long id, final Long activityId);
}
