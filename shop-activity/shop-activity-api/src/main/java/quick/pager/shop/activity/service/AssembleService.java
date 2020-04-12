package quick.pager.shop.activity.service;

import java.util.List;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.activity.request.assemble.AssemblePageRequest;
import quick.pager.shop.activity.request.assemble.AssembleRuleSaveRequest;
import quick.pager.shop.activity.request.assemble.AssembleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;
import quick.pager.shop.activity.response.assemble.AssembleResponse;
import quick.pager.shop.activity.response.assemble.AssembleActivityResponse;
import quick.pager.shop.response.Response;

/**
 * 拼团活动
 *
 * @author siguiyang
 */
public interface AssembleService {

    /**
     * 拼团活动列表
     *
     * @param request 请求参数
     * @return 拼团活动列表
     */
    Response<List<AssembleActivityResponse>> queryPage(AssemblePageRequest request);

    /**
     * 修改拼团活动
     *
     * @param request 拼团参数
     * @return 活动主键
     */
    Response<Long> modify(AssembleSaveRequest request);

    /**
     * 新增拼团活动
     *
     * @param request 拼团参数
     * @return 活动主键
     */
    Response<Long> create(AssembleSaveRequest request);

    /**
     * 拼团活动规则
     *
     * @param activityId 活动主键
     * @return 拼团活动内容
     */
    Response<AssembleResponse> ruleInfo(Long activityId);

    /**
     * 修改规则
     *
     * @param request 请求参数
     * @return 拼团规则主键
     */
    Response<Long> modifyRule(AssembleRuleSaveRequest request);

    /**
     * 设置拼团商品
     */
//    Response assembleGoods(AssemblePageRequest request);

    /**
     * 参与拼团成员
     *
     * @param request 请求参数
     * @return 拼团参与人员
     */
    Response<List<AssembleMemberResponse>> members(AssembleMemberPageRequest request);
}
