package quick.pager.shop.manage.controller.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.client.ActivityClient;
import quick.pager.shop.feign.dto.FightGroupDTO;

/**
 * 拼团管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class FightGroupManageController {

    @Autowired
    private ActivityClient activityClient;

    /**
     * 活动列表
     */
    @PostMapping("/activity/fightGroup/list")
    public Response list(FightGroupDTO request) {
        return activityClient.fightGroup(request);
    }

    /**
     * 新增修改
     */
    @PostMapping("/activity/fightGroup/modify")
    public Response modify(FightGroupDTO request) {
        return activityClient.modify(request);
    }

    /**
     * 活动规则详情
     */
    @PostMapping("/activity/fightGroup/rule/info")
    public Response ruleInfo(FightGroupDTO request) {
        return activityClient.rule(request.getId());
    }

    /**
     * 活动规则
     */
    @PostMapping("/activity/fightGroup/rule/modify")
    public Response rule(FightGroupDTO request) {
        return activityClient.modifyRule(request);
    }

    /**
     * 活动商品详情
     */
    @PostMapping("/activity/fightGroup/goods/info")
    public Response goodsInfo(FightGroupDTO request) {
        return activityClient.goodsInfo(request.getId());
    }

    /**
     * 活动商品
     */
    @PostMapping("/activity/fightGroup/goods/modify")
    public Response goods(FightGroupDTO request) {
        return activityClient.goodsModify(request);
    }

    /**
     * 活动成团记录
     */
    @PostMapping("/activity/fightGroup/record")
    public Response record(FightGroupDTO request) {
        return activityClient.records(request);
    }

    @PostMapping("/activity/fightGroup/members")
    public Response members(Long recordId, Integer page, Integer pageSize) {
        return activityClient.members(recordId, page, pageSize);
    }
}
