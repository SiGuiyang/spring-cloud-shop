package quick.pager.shop.manage.controller.goods;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.goods.response.brand.GoodsBrandGroupResponse;
import quick.pager.shop.manage.param.goods.GoodsBrandGroupPageParam;
import quick.pager.shop.manage.param.goods.GoodsBrandGroupSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.goods.GoodsBrandGroupService;

/**
 * 商品管理 -> 品牌组
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsBrandGroupController {

    @Autowired
    private GoodsBrandGroupService goodsBrandGroupService;

    /**
     * 新建商品品牌组
     */
    @PreAuthorize("hasAuthority('PAGER_ACTIVITY_GOODS_GROUP_CREATE')")
    @PostMapping("/goods/brand/group/create")
    public Response create(@RequestBody GoodsBrandGroupSaveParam param) {
        return goodsBrandGroupService.create(param);
    }

    /**
     * 修改商品品牌组
     */
    @PreAuthorize("hasAuthority('PAGER_ACTIVITY_GOODS_GROUP_MODIFY')")
    @PutMapping("/goods/brand/group/modify")
    public Response modify(@RequestBody GoodsBrandGroupSaveParam param) {
        return goodsBrandGroupService.modify(param);
    }

    /**
     * 商品品牌组列表
     */
    @PreAuthorize("hasAuthority('PAGER_ACTIVITY_GOODS_GROUP')")
    @PostMapping(value = "/goods/brand/group/list")
    public Response<List<GoodsBrandGroupResponse>> list(@RequestBody GoodsBrandGroupPageParam param) {
        return goodsBrandGroupService.list(param);
    }

    /**
     * 商品品牌组所有列表
     */
    @PostMapping(value = "/goods/brand/group/listAll")
    public Response<List<GoodsBrandGroupResponse>> listAll() {
        return goodsBrandGroupService.listAll();
    }

}
