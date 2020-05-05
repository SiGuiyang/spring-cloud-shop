package quick.pager.shop.activity.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.activity.request.assemble.AssemblePageRequest;
import quick.pager.shop.activity.request.assemble.AssembleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleActivityResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
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
    @PostMapping("/assemble/page")
    public Response<List<AssembleActivityResponse>> page(@RequestBody AssemblePageRequest request) {
        return assembleService.queryPage(request);
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
    public Response<Long> modify(@RequestBody AssembleSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return assembleService.modify(request);
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
     *
     * @param request 请求参数
     */
    @PostMapping("/assemble/members")
    public Response members(@RequestBody AssembleMemberPageRequest request) {
        return assembleService.members(request);
    }

}
