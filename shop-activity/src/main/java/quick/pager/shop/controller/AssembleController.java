package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class AssembleController {
    @Autowired
    private AssembleService assembleService;

    /**
     * 拼团活动列表
     */
    @PostMapping("/assemble/list")
    public Response list(@RequestBody AssembleDTO dto) {
        return assembleService.list(dto);
    }

    /**
     * 新增拼团活动
     */
    @PostMapping("/assemble/create")
    public Response create(@RequestBody AssembleDTO dto) {
        return assembleService.create(dto);
    }

    /**
     * 修改拼团活动
     */
    @PutMapping("/assemble/modify")
    public Response modifyActivity(@RequestBody AssembleDTO dto) {
        return assembleService.modify(dto);
    }

    /**
     * 规则详情
     */
    @PostMapping("/assemble/{activityId}/rule")
    public Response rule(@PathVariable("activityId") Long activityId) {
        return assembleService.ruleInfo(activityId);
    }

    /**
     * 拼团活动规则新增修改
     */
    @PutMapping("/assemble/rule/modify")
    public Response modifyRule(@RequestBody AssembleDTO dto) {
        return assembleService.modifyRule(dto);
    }

    /**
     * 拼团活动商品详情
     */
    @PostMapping("/assemble/{activityId}/goods")
    public Response assembleGoodsInfo(@PathVariable("activityId") Long activityId) {
        return null;
    }

    /**
     * 拼团规则的商品新增修改
     */
    @PostMapping("/assemble/goods/modify")
    public Response goodsModify(@RequestBody AssembleDTO dto) {
        return assembleService.assembleGoods(dto);
    }

    /**
     * 参与拼团的成员
     */
    @PostMapping("/assemble/goods/members")
    public Response members(@RequestBody AssembleDTO dto) {
        return assembleService.members(dto);
    }

}
