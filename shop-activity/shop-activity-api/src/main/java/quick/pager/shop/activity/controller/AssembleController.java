package quick.pager.shop.activity.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.activity.request.assemble.AssemblePageRequest;
import quick.pager.shop.activity.request.assemble.AssembleRuleSaveRequest;
import quick.pager.shop.activity.request.assemble.AssembleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleActivityResponse;
import quick.pager.shop.activity.response.assemble.AssembleResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.AssembleService;

/**
 * 拼团
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class AssembleController {
    @Autowired
    private AssembleService assembleService;

    /**
     * 拼团活动列表
     */
    @PostMapping("/assemble/list")
    public Response<List<AssembleActivityResponse>> list(@RequestBody AssemblePageRequest request) {
        return assembleService.list(request);
    }

    /**
     * 新增拼团活动
     */
    @PostMapping("/assemble/create")
    public Response<Long> create(@RequestBody AssembleSaveRequest request) {
        return assembleService.create(request);
    }

    /**
     * 修改拼团活动
     */
    @PutMapping("/assemble/modify")
    public Response<Long> modifyActivity(@RequestBody AssembleSaveRequest request) {
        return assembleService.modify(request);
    }

    /**
     * 规则详情
     */
    @GetMapping("/assemble/{activityId}/rule")
    public Response<AssembleResponse> rule(@PathVariable("activityId") Long activityId) {
        return assembleService.ruleInfo(activityId);
    }

    /**
     * 拼团活动规则新增修改
     */
    @PutMapping("/assemble/rule/modify")
    public Response<Long> modifyRule(@RequestBody AssembleRuleSaveRequest request) {
        return assembleService.modifyRule(request);
    }

    /**
     * 拼团活动商品详情
     */
    @PostMapping("/assemble/{activityId}/goods")
    public Response assembleGoodsInfo(@PathVariable("activityId") Long activityId) {
        return null;
    }

//    /**
//     * 拼团规则的商品新增修改
//     */
//    @PostMapping("/assemble/goods/modify")
//    public Response goodsModify(@RequestBody AssemblePageRequest request) {
//        return assembleService.assembleGoods(request);
//    }

    /**
     * 参与拼团的成员
     */
    @PostMapping("/assemble/members")
    public Response members(@RequestBody AssembleMemberPageRequest request) {
        return assembleService.members(request);
    }

}
