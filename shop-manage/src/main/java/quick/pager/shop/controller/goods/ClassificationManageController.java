package quick.pager.shop.controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.goods.ClassificationDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.goods.GoodsClassService;

/**
 * 商品分类
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class ClassificationManageController {

    @Autowired
    private GoodsClassService goodsClassService;

    /**
     * 商品分类列表
     */
    @PostMapping("/goods/classification/list")
    public Response classification(@RequestBody ClassificationDTO dto) {
        return goodsClassService.list(dto);
    }

    /**
     * 商品分类修改
     */
    @PostMapping("/goods/classification/create")
    public Response create(@RequestBody ClassificationDTO dto) {
        return goodsClassService.create(dto);
    }

    /**
     * 商品分类修改
     */
    @PutMapping("/goods/classification/modify")
    public Response modify(@RequestBody ClassificationDTO dto) {
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
