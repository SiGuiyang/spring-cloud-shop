package quick.pager.shop.manage.controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.manage.param.goods.GoodsBrandPageParam;
import quick.pager.shop.manage.param.goods.GoodsBrandSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.goods.GoodsBrandService;

/**
 * 商品管理-->品牌管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsBrandController {

    @Autowired
    private GoodsBrandService goodsBrandService;

    /**
     * 品牌列表
     */
    @PreAuthorize("hasAuthority('PAGER_ACTIVITY_GOODS_BRAND')")
    @PostMapping("/goods/brand/list")
    public Response list(@RequestBody GoodsBrandPageParam param) {

        return goodsBrandService.list(param);
    }

    /**
     * 品牌创建或修改
     */
    @PreAuthorize("hasAuthority('PAGER_ACTIVITY_GOODS_BRAND_CREATE')")
    @PostMapping("/goods/brand/create")
    public Response create(@RequestBody GoodsBrandSaveParam param) {
        return goodsBrandService.create(param);
    }

    /**
     * 品牌修改
     */
    @PreAuthorize("hasAuthority('PAGER_ACTIVITY_GOODS_BRAND_MODIFY')")
    @PutMapping("/goods/brand/modify")
    public Response modify(@RequestBody GoodsBrandSaveParam param) {
        return goodsBrandService.modify(param);
    }
}
