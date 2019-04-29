package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.FightGroupDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.client.FightGroupClientService;

/**
 * 拼团
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
@Api(description = "拼团接口")
public class FightGroupController {

    @Autowired
    private FightGroupClientService fightGroupClientService;

    @ApiOperation("管理后台 拼团活动列表")
    @RequestMapping(value = "/fightGroup/list", method = RequestMethod.POST)
    public Response fightGroupActivityList(@RequestBody FightGroupDTO request) {
        return fightGroupClientService.fightGroup(request.getActivityName(), request.getBeginTime(), request.getEndTime(), request.getPage(), request.getPageSize());
    }

    @ApiOperation("管理后台 新增拼团活动")
    @RequestMapping(value = "/fightGroup/modify", method = RequestMethod.POST)
    public Response addFightGroupActivity(@RequestBody FightGroupDTO request) {
        request.setEvent(Constants.Event.ADD);
        return fightGroupClientService.modify(request);
    }

    @ApiOperation("管理后台 修改拼团活动")
    @RequestMapping(value = "/fightGroup/modify", method = RequestMethod.PUT)
    public Response modifyFightGroupActivity(@RequestBody FightGroupDTO request) {
        request.setEvent(Constants.Event.MODIFY);
        return fightGroupClientService.modify(request);
    }

    @ApiOperation("规则详情")
    @RequestMapping("/fightGroup/rule/{activityId}")
    public Response rule(@PathVariable("activityId") Long activityId) {
        return fightGroupClientService.queryFightGroupRuleInfo(activityId);
    }

    @ApiOperation("拼团活动规则新增修改")
    @RequestMapping(value = "/fightGroup/rule/modify", method = RequestMethod.POST)
    public Response modifyRule(@RequestBody FightGroupDTO request) {
        return fightGroupClientService.rule(request);
    }

    @ApiOperation("拼团规则的商品新增修改")
    @RequestMapping(value = "/fightGroup/goods/modify", method = RequestMethod.POST)
    public Response goodsModify(@RequestBody FightGroupDTO request) {
        return fightGroupClientService.goodsModify(request);
    }

    @ApiOperation("参与成团人员")
    @RequestMapping(value = "/fightGroup/members", method = RequestMethod.POST)
    public Response fightGroupMembers(@RequestBody FightGroupDTO request) {
        return fightGroupClientService.fightGroupMembers(request.getActivityId(), request.getPhone(), request.getPage(), request.getPageSize());
    }

    /**
     * 拼团活动商品详情
     */
    @RequestMapping(value = "/fightGroup/goods/{activityId}", method = RequestMethod.POST)
    public Response fightGroupGoodsInfo(@PathVariable("activityId") Long activityId) {
        return fightGroupClientService.fightGroupGoodsInfo(activityId);
    }

    /**
     * 拼团规则的商品
     *
     * @param activityId 活动Id
     * @param goodsId    商品Id
     */
    @RequestMapping(value = "/fightGroup/goods/modify", method = RequestMethod.PUT)
    public Response setFightGroupGoods(@RequestParam("activityId") Long activityId, @RequestParam("goodsId") Long goodsId) {
        return fightGroupClientService.setFightGroupGoods(activityId, goodsId);
    }


    /**
     * 查询当前活动的商品是否存在
     * @param activityId 活动Id
     * @param goodsId 商品Id
     */
    @RequestMapping(value = "/fight/goods/{activityId}/{goodsId}")
    public Response queryFightGroupGoods(@PathVariable("activityId") Long activityId, @PathVariable("goodsId") Long goodsId){
        return fightGroupClientService.queryFightGroupGoods(activityId,goodsId);
    }


}
