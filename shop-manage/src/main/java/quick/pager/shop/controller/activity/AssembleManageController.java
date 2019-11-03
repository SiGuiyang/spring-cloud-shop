package quick.pager.shop.controller.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.activity.AssembleDTO;
import quick.pager.shop.service.activity.AssembleService;
import quick.pager.shop.utils.DateUtils;

/**
 * 拼团管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class AssembleManageController {

    @Autowired
    private AssembleService assembleService;

    /**
     * 活动列表
     */
    @PostMapping("/activity/assemble/list")
    public Response list(@RequestBody AssembleDTO dto) {
        return assembleService.list(dto);
    }

    /**
     * 拼团活动新增
     */
    @PostMapping("/activity/assemble/create")
    public Response create(@RequestBody AssembleDTO dto) {

        if (!CollectionUtils.isEmpty(dto.getTimeRange())) {
            dto.setBeginTime(DateUtils.parseDateTime(dto.getTimeRange().get(0)));
            dto.setEndTime(DateUtils.parseDateTime(dto.getTimeRange().get(1)));
        }
        return assembleService.create(dto);
    }

    /**
     * 拼团活动修改
     */
    @PutMapping("/activity/assemble/modify")
    public Response modify(@RequestBody AssembleDTO dto) {
        return assembleService.modify(dto);
    }

    /**
     * 活动规则详情
     */
    @PostMapping("/activity/assemble/rule/{activityId}")
    public Response ruleInfo(@PathVariable("activityId") Long activityId) {
        return assembleService.ruleInfo(activityId);
    }

    /**
     * 活动规则
     */
    @PostMapping("/activity/assemble/rule/modify")
    public Response rule(@RequestBody AssembleDTO dto) {
        return assembleService.modifyRule(dto);
    }

    /**
     * 活动商品详情
     */
    @PostMapping("/activity/assemble/goods/{activityId}")
    public Response fightGroupGoodsInfo(@PathVariable("activityId") Long activityId) {
        return assembleService.fightGroupGoodsInfo(activityId);
    }

    /**
     * 设置活动商品
     */
    @PutMapping("/activity/assemble/goods/modify")
    public Response setFightGroupGoods(@RequestBody AssembleDTO dto) {
        return assembleService.setFightGroupGoods(dto);
    }
    /**
     * 活动成团记录成员
     */
    @PostMapping("/activity/assemble/members")
    public Response members(@RequestBody AssembleDTO dto) {
        return assembleService.members(dto);
    }
}
