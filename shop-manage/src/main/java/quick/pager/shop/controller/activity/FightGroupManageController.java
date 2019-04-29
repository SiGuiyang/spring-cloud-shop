package quick.pager.shop.controller.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.dto.FightGroupDTO;
import quick.pager.shop.service.activity.FightGroupService;

/**
 * 拼团管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class FightGroupManageController {

    @Autowired
    private FightGroupService fightGroupService;

    /**
     * 活动列表
     */
    @PostMapping("/activity/fightGroup/list")
    public Response list(FightGroupDTO request) {
        return fightGroupService.fightGroupActivityList(request);
    }

    /**
     * 拼团活动新增
     */
    @PostMapping("/activity/fightGroup/modify")
    public Response addFightGroupActivity(FightGroupDTO request) {
        return fightGroupService.addFightGroupActivity(request);
    }

    /**
     * 拼团活动修改
     */
    @PutMapping("/activity/fightGroup/modify")
    public Response modifyFightGroupActivity(FightGroupDTO request) {
        return fightGroupService.modifyFightGroupActivity(request);
    }

    /**
     * 活动规则详情
     */
    @PostMapping("/activity/fightGroup/rule/{activityId}")
    public Response ruleInfo(@PathVariable("activityId") Long activityId) {
        return fightGroupService.fightGroupActivityRuleInfo(activityId);
    }

    /**
     * 活动规则
     */
    @PostMapping("/activity/fightGroup/rule/modify")
    public Response rule(FightGroupDTO request) {
        return fightGroupService.modifyFightGroupRule(request);
    }

    /**
     * 活动商品详情
     */
    @PostMapping("/activity/fightGroup/goods/{activityId}")
    public Response fightGroupGoodsInfo(@PathVariable("activityId") Long activityId) {
        return fightGroupService.fightGroupGoodsInfo(activityId);
    }

    /**
     * 设置活动商品
     */
    @PutMapping("/activity/fightGroup/goods/modify")
    public Response setFightGroupGoods(FightGroupDTO request) {
        return fightGroupService.setFightGroupGoods(request);
    }

    /**
     * 活动成团记录成员
     */
    @PostMapping("/activity/fightGroup/members")
    public Response fightGroupRecord(FightGroupDTO request) {
        return fightGroupService.fightGroupRecord(request);
    }
}
