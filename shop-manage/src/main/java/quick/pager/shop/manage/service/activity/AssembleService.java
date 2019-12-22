package quick.pager.shop.manage.service.activity;

import java.util.List;
import quick.pager.shop.activity.response.assemble.AssembleActivityResponse;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;
import quick.pager.shop.activity.response.assemble.AssembleResponse;
import quick.pager.shop.manage.param.assemble.AssemblePageParam;
import quick.pager.shop.manage.param.assemble.AssembleMemberParam;
import quick.pager.shop.manage.param.assemble.AssembleRuleSaveParam;
import quick.pager.shop.manage.param.assemble.AssembleSaveParam;
import quick.pager.shop.response.Response;

/**
 * 拼团服务
 *
 * @author siguiyang
 */
public interface AssembleService {

    /**
     * 拼团活动列表
     */
    Response<List<AssembleActivityResponse>> list(AssemblePageParam param);

    /**
     * 修改拼团活动
     */
    Response<Long> modify(AssembleSaveParam param);

    /**
     * 新增拼团活动
     */
    Response<Long> create(AssembleSaveParam param);

    /**
     * 拼团规则详情
     *
     * @param activityId 拼团活动Id
     */
    Response<AssembleResponse> ruleInfo(Long activityId);

    /**
     * 修改评团活动规则
     */
    Response<Long> modifyRule(AssembleRuleSaveParam param);

    /**
     * 成团记录
     */
    Response<List<AssembleMemberResponse>> members(AssembleMemberParam param);

    /**
     * 活动商品详情
     *
     * @param activityId 活动Id
     */
    Response fightGroupGoodsInfo(Long activityId);

    /**
     * 设置活动商品
     */
    Response setFightGroupGoods(AssembleMemberParam request);
}
