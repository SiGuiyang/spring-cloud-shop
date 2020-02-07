package quick.pager.shop.manage.controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.manage.param.goods.ClassificationPageParam;
import quick.pager.shop.manage.param.goods.ClassificationSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.goods.GoodsClassService;

/**
 * 商品分类
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class ClassificationController {

    @Autowired
    private GoodsClassService goodsClassService;

    /**
     * 商品分类列表
     */
    @PreAuthorize("hasAuthority('PAGER_GOODS_CLASSIFICATION')")
    @PostMapping("/goods/classification/list")
    public Response classification(@RequestBody ClassificationPageParam dto) {
        return goodsClassService.list(dto);
    }

    /**
     * 商品分类修改
     */
    @PreAuthorize("hasAuthority('PAGER_GOODS_CLASSIFICATION_CREATE')")
    @PostMapping("/goods/classification/create")
    public Response create(@RequestBody ClassificationSaveParam dto) {
        return goodsClassService.create(dto);
    }

    /**
     * 商品分类修改
     */
    @PreAuthorize("hasAuthority('PAGER_GOODS_CLASSIFICATION_MODIFY')")
    @PutMapping("/goods/classification/modify")
    public Response modify(@RequestBody ClassificationSaveParam dto) {
        return goodsClassService.modify(dto);
    }

    /**
     * 商品分类树形结构
     */
    @PostMapping("/goods/classification/tree")
    public Response classificationTree() {
        return goodsClassService.tree();
    }
}
