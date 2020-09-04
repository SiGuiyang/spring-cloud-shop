package quick.pager.shop.service;

import quick.pager.shop.model.AssembleActivityRule;
import quick.pager.shop.activity.request.assemble.AssembleRuleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleActivityRuleResponse;
import quick.pager.shop.user.response.Response;

/**
 * 评团规则
 *
 * @author siguiyang
 */
public interface AssembleRuleService extends IService<AssembleActivityRule> {

    /**
     * 拼团活动规则
     *
     * @param activityId 活动主键
     * @return 拼团活动内容
     */
    Response<AssembleActivityRuleResponse> info(Long activityId);

    /**
     * 修改规则
     *
     * @param request 请求参数
     * @return 拼团规则主键
     */
    Response<Long> rule(AssembleRuleSaveRequest request);
}
