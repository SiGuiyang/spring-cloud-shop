package quick.pager.shop.goods.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.model.GoodsBrandGroup;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupSaveRequest;
import quick.pager.shop.goods.service.GoodsBrandGroupService;
import quick.pager.shop.response.Response;

/**
 * 商品品牌组
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsBrandGroupController {

    @Autowired
    private GoodsBrandGroupService goodsBrandGroupService;

    /**
     * 新建商品品牌组
     */
    @PostMapping("/brand/group/create")
    public Response create(@RequestBody GoodsBrandGroupSaveRequest request) {

        return goodsBrandGroupService.create(request);
    }

    /**
     * 修改商品品牌组
     */
    @PostMapping("/brand/group/modify")
    public Response<Long> modify(@RequestBody GoodsBrandGroupSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return goodsBrandGroupService.modify(request);
    }

    /**
     * 商品品牌组列表
     */
    @PostMapping("/brand/group/page")
    public Response<List<GoodsBrandGroup>> queryPage(@RequestBody GoodsBrandGroupPageRequest request) {
        return goodsBrandGroupService.queryPage(request);
    }

    /**
     * 商品品牌组所有列表
     */
    @PostMapping("/brand/group/listAll")
    public Response<List<GoodsBrandGroup>> listAll() {
//        QueryWrapper<GoodsBrandGroup> qw = new QueryWrapper<>();
//        qw.eq("delete_status", Boolean.FALSE);
//        return Response.toResponse(goodsBrandGroupService.queryList(qw), 0);
        return null;
    }
}
