package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.activity.AssembleDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.AssembleService;

/**
 * 拼团
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
@Api(description = "拼团接口")
public class AssembleController {
    @Autowired
    private AssembleService assembleService;

    @ApiOperation("管理后台 拼团活动列表")
    @RequestMapping(value = "/assemble/list", method = RequestMethod.POST)
    public Response list(@RequestBody AssembleDTO dto) {
        return assembleService.list(dto);
    }

    @ApiOperation("管理后台 新增拼团活动")
    @RequestMapping(value = "/assemble/create", method = RequestMethod.POST)
    public Response create(@RequestBody AssembleDTO dto) {
        return assembleService.create(dto);
    }

    @ApiOperation("管理后台 修改拼团活动")
    @RequestMapping(value = "/assemble/modify", method = RequestMethod.PUT)
    public Response modifyActivity(@RequestBody AssembleDTO dto) {
        return assembleService.modify(dto);
    }

    @ApiOperation("规则详情")
    @RequestMapping("/assemble/{activityId}/rule")
    public Response rule(@PathVariable("activityId") Long activityId) {
        return assembleService.ruleInfo(activityId);
    }

    @ApiOperation("拼团活动规则新增修改")
    @RequestMapping(value = "/assemble/rule/modify", method = RequestMethod.PUT)
    public Response modifyRule(@RequestBody AssembleDTO dto) {
        return assembleService.modifyRule(dto);
    }

    @ApiOperation("拼团活动商品详情")
    @RequestMapping(value = "/assemble/{activityId}/goods", method = RequestMethod.POST)
    public Response assembleGoodsInfo(@PathVariable("activityId") Long activityId) {
        return null;
    }

    @ApiOperation("拼团规则的商品新增修改")
    @RequestMapping(value = "/assemble/goods/modify", method = RequestMethod.POST)
    public Response goodsModify(@RequestBody AssembleDTO dto) {
        return assembleService.assembleGoods(dto);
    }

    @ApiOperation("参与拼团的成员")
    @RequestMapping(value = "/assemble/goods/members", method = RequestMethod.POST)
    public Response members(@RequestBody AssembleDTO dto) {
        return assembleService.members(dto);
    }

}
