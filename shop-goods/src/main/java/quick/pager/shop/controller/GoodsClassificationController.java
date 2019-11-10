package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.goods.ClassificationDTO;
import quick.pager.shop.model.goods.GoodsClass;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsClassService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;
import quick.pager.shop.utils.DateUtils;

/**
 * 商品分类
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsClassificationController {

    @Autowired
    private GoodsClassService goodsClassService;

    /**
     * 商品分类列表
     */
    @PostMapping("/classification/list")
    public Response list(@RequestBody ClassificationDTO dto) {
        return goodsClassService.getGoodsClass(dto.getClassName(), dto.getPage(), dto.getPageSize());

    }

    /**
     * 新增商品分类
     */
    @PostMapping("/classification/create")
    public Response create(@RequestBody ClassificationDTO dto) {
        GoodsClass gc = this.convert(dto);
        gc.setCreateTime(DateUtils.dateTime());
        gc.setDeleteStatus(Boolean.FALSE);
        goodsClassService.save(gc);
        return new Response();
    }

    /**
     * 商品分类修改
     */
    @PutMapping("/classification/modify")
    public Response modify(@RequestBody ClassificationDTO dto) {
        GoodsClass gc = this.convert(dto);
        goodsClassService.updateById(gc);
        return new Response();
    }

    /**
     * 商品分类树形结构
     */
    @PostMapping("/classification/tree")
    public Response classificationTree() {
        return goodsClassService.classificationTree();
    }

    /**
     * DTO -> db model
     */
    private GoodsClass convert(ClassificationDTO dto) {
        return BeanCopier.create(dto, new GoodsClass(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true))
                .copy();
    }
}
