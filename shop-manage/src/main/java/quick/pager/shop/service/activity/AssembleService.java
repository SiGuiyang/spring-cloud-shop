package quick.pager.shop.service.activity;

import quick.pager.shop.dto.activity.AssembleDTO;
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
    Response list(AssembleDTO dto);

    /**
     * 修改拼团活动
     */
    Response modify(AssembleDTO dto);

    /**
     * 新增拼团活动
     */
    Response create(AssembleDTO dto);

    /**
     * 拼团规则详情
     *
     * @param activityId 拼团活动Id
     */
    Response ruleInfo(Long activityId);

    /**
     * 修改评团活动规则
     */
    Response modifyRule(AssembleDTO dto);

    /**
     * 成团记录
     */
    Response members(AssembleDTO dto);

    /**
     * 活动商品详情
     *
     * @param activityId 活动Id
     */
    Response fightGroupGoodsInfo(Long activityId);

    /**
     * 设置活动商品
     */
    Response setFightGroupGoods(AssembleDTO request);
}
