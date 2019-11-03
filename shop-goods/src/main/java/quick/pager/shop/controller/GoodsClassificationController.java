package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.goods.ClassificationDTO;
import quick.pager.shop.model.goods.GoodsClass;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsClassService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;

/**
 * 商品分类
 *
 * @author siguiyang
 */
@Api(description = "商品分类")
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsClassificationController {


    @Autowired
    private GoodsClassService goodsClassService;

    @ApiOperation("新增商品分类")
    @RequestMapping(value = "/classification/create", method = RequestMethod.POST)
    public Response create(@RequestBody ClassificationDTO dto) {
        GoodsClass gc = this.convert(dto);
        goodsClassService.save(gc);
        return new Response();
    }

    @ApiOperation("商品分类修改")
    @RequestMapping(value = "/classification/modify", method = RequestMethod.POST)
    public Response modify(@RequestBody ClassificationDTO dto) {
        GoodsClass gc = this.convert(dto);
        goodsClassService.updateById(gc);
        return new Response();
    }

    @ApiOperation("商品分类列表")
    @RequestMapping(value = "/classification/list", method = RequestMethod.POST)
    public Response list(@RequestBody ClassificationDTO dto) {
        return goodsClassService.getGoodsClass(dto.getClassName(), dto.getPage(), dto.getPageSize());

    }

    @ApiOperation("商品分类树形结构")
    @RequestMapping(value = "/classification/tree", method = RequestMethod.POST)
    public Response classificationTree() {
        return goodsClassService.classificationTree();
    }

    /**
     * DTO -> db model
     */
    private GoodsClass convert(ClassificationDTO dto) {
        GoodsClass gc = new GoodsClass();
        BeanCopier.create(dto, gc, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true)).copy();
        return gc;
    }
}
