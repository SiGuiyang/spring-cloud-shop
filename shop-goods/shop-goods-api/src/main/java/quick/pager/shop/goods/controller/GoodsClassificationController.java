package quick.pager.shop.goods.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
//import quick.pager.shop.param.goods.ClassificationDTO;
import quick.pager.shop.goods.model.GoodsClass;
import quick.pager.shop.goods.request.classification.GoodsClassificationRequest;
import quick.pager.shop.goods.request.classification.GoodsClassificationSaveRequest;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.goods.service.GoodsClassService;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.BeanCopier;
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
    public Response<List<GoodsClassificationResponse>> list(@RequestBody GoodsClassificationRequest request) {
        return goodsClassService.getGoodsClass(request.getClassName(), request.getPage(), request.getPageSize());

    }

    /**
     * 新增商品分类
     */
    @PostMapping("/classification/create")
    public Response<Long> create(@RequestBody GoodsClassificationSaveRequest request) {
        GoodsClass gc = this.convert(request);
        gc.setCreateTime(DateUtils.dateTime());
        gc.setDeleteStatus(Boolean.FALSE);
        goodsClassService.save(gc);
        return new Response<>(gc.getId());
    }

    /**
     * 商品分类修改
     */
    @PutMapping("/classification/modify")
    public Response<Long> modify(@RequestBody GoodsClassificationSaveRequest request) {
        GoodsClass gc = this.convert(request);
        goodsClassService.updateById(gc);
        return new Response<>(gc.getId());
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
    private GoodsClass convert(GoodsClassificationSaveRequest request) {
        return BeanCopier.create(request, new GoodsClass()).copy();
    }
}
