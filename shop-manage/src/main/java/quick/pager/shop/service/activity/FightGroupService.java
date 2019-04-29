package quick.pager.shop.service.activity;

import quick.pager.shop.dto.FightGroupDTO;
import quick.pager.shop.response.Response;

/**
 * 拼团服务
 *
 * @author siguiyang
 */
public interface FightGroupService {

    /**
     * 拼团活动列表
     */
    Response fightGroupActivityList(FightGroupDTO dto);

    /**
     * 修改拼团活动
     */
    Response modifyFightGroupActivity(FightGroupDTO dto);

    /**
     * 新增拼团活动
     */
    Response addFightGroupActivity(FightGroupDTO dto);

    /**
     * 拼团规则详情
     *
     * @param activityId 拼团活动Id
     */
    Response fightGroupActivityRuleInfo(Long activityId);

    /**
     * 修改评团活动规则
     */
    Response modifyFightGroupRule(FightGroupDTO dto);

    /**
     * 成团记录
     */
    Response fightGroupRecord(FightGroupDTO dto);

    /**
     * 活动商品详情
     *
     * @param activityId 活动Id
     */
    Response fightGroupGoodsInfo(Long activityId);

    /**
     * 设置活动商品
     */
    Response setFightGroupGoods(FightGroupDTO request);
}
