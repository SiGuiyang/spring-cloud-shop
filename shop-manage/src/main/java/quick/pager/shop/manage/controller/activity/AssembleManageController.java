package quick.pager.shop.manage.controller.activity;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;
import quick.pager.shop.activity.response.assemble.AssembleResponse;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.manage.param.assemble.AssemblePageParam;
import quick.pager.shop.manage.param.assemble.AssembleMemberParam;
import quick.pager.shop.manage.param.assemble.AssembleRuleSaveParam;
import quick.pager.shop.manage.param.assemble.AssembleSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.activity.AssembleService;

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
    public Response list(@RequestBody AssemblePageParam param) {
        return assembleService.list(param);
    }

    /**
     * 拼团活动新增
     */
    @PostMapping("/activity/assemble/create")
    public Response create(@RequestBody AssembleSaveParam param) {
        return assembleService.create(param);
    }

    /**
     * 拼团活动修改
     */
    @PutMapping("/activity/assemble/modify")
    public Response modify(@RequestBody AssembleSaveParam dto) {
        return assembleService.modify(dto);
    }

    /**
     * 活动规则详情
     */
    @GetMapping("/activity/assemble/rule/{activityId}")
    public Response<AssembleResponse> ruleInfo(@PathVariable("activityId") Long activityId) {
        return assembleService.ruleInfo(activityId);
    }

    /**
     * 活动规则
     */
    @PutMapping("/activity/assemble/rule/modify")
    public Response<Long> rule(@RequestBody AssembleRuleSaveParam param) {
        if (Objects.isNull(param.getActivityId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return assembleService.modifyRule(param);
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
    public Response setFightGroupGoods(@RequestBody AssembleMemberParam dto) {
        return assembleService.setFightGroupGoods(dto);
    }

    /**
     * 活动成团记录成员
     */
    @PostMapping("/activity/assemble/members")
    public Response<List<AssembleMemberResponse>> members(@RequestBody AssembleMemberParam param) {
        if (Objects.isNull(param.getActivityId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return assembleService.members(param);
    }
}
