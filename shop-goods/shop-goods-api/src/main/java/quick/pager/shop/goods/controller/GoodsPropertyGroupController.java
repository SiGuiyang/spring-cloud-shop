package quick.pager.shop.goods.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.request.property.group.GoodsPropertyGroupOtherRequest;
import quick.pager.shop.goods.request.property.group.GoodsPropertyGroupPageRequest;
import quick.pager.shop.goods.request.property.group.GoodsPropertyGroupSaveRequest;
import quick.pager.shop.goods.response.property.group.GoodsPropertyGroupResponse;
import quick.pager.shop.goods.service.GoodsPropertyGroupService;
import quick.pager.shop.response.Response;

/**
 * 商品属性组
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.GOODS)
public class GoodsPropertyGroupController {

    @Autowired
    private GoodsPropertyGroupService goodsPropertyGroupService;

    /**
     * 分页
     *
     * @param request 请求参数
     * @return 返回结果
     */
    @PostMapping("/property/group/page")
    public Response<List<GoodsPropertyGroupResponse>> page(@RequestBody GoodsPropertyGroupPageRequest request) {

        return goodsPropertyGroupService.queryPage(request);
    }

    /**
     * 属性组列表
     *
     * @param request 请求参数
     * @return 返回结果
     */
    @GetMapping("/property/group/list")
    public Response<List<GoodsPropertyGroupResponse>> list(GoodsPropertyGroupOtherRequest request) {

        return goodsPropertyGroupService.queryList(request);
    }

    /**
     * 新增
     *
     * @param request 请求参数
     * @return 返回结果
     */
    @PostMapping("/property/group/create")
    public Response<Long> create(@RequestBody GoodsPropertyGroupSaveRequest request) {

        return goodsPropertyGroupService.create(request);
    }

    /**
     * 编辑
     *
     * @param request 请求参数
     * @return 返回结果
     */
    @PutMapping("/property/group/modify")
    public Response<Long> modify(@RequestBody GoodsPropertyGroupSaveRequest request) {

        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return goodsPropertyGroupService.modify(request);
    }
}
