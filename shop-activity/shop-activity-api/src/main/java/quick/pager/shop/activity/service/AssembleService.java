package quick.pager.shop.activity.service;

import java.util.List;
import quick.pager.shop.activity.model.AssembleActivity;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.activity.request.assemble.AssemblePageRequest;
import quick.pager.shop.activity.request.assemble.AssembleRuleSaveRequest;
import quick.pager.shop.activity.request.assemble.AssembleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;
import quick.pager.shop.activity.response.assemble.AssembleResponse;
import quick.pager.shop.activity.response.assemble.AssembleActivityResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IPageService;

/**
 * 拼团活动
 *
 * @author siguiyang
 */
public interface AssembleService extends IPageService<AssembleActivity> {

    /**
     * 拼团活动列表
     */
    Response<List<AssembleActivityResponse>> list(AssemblePageRequest request);

    /**
     * 修改拼团活动
     */
    Response<Long> modify(AssembleSaveRequest request);

    /**
     * 新增拼团活动
     */
    Response<Long> create(AssembleSaveRequest request);

    /**
     * 拼团活动规则
     *
     * @param activityId 活动主键
     */
    Response<AssembleResponse> ruleInfo(Long activityId);

    /**
     * 修改规则
     */
    Response<Long> modifyRule(AssembleRuleSaveRequest request);

    /**
     * 设置拼团商品
     */
//    Response assembleGoods(AssemblePageRequest request);

    /**
     * 参与拼团成员
     */
    Response<List<AssembleMemberResponse>> members(AssembleMemberPageRequest request);
}
