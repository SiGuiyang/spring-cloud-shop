package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.AssembleService;

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
     *
     * @param request 请求参数
     */
    @PostMapping("/assemble/members")
    public Response members(@RequestBody AssembleMemberPageRequest request) {
        return assembleService.members(request);
    }

}
