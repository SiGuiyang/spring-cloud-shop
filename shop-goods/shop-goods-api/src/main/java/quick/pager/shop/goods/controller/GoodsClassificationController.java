package quick.pager.shop.goods.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.request.classification.GoodsClassificationRequest;
import quick.pager.shop.goods.request.classification.GoodsClassificationSaveRequest;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.goods.service.GoodsClassService;
import quick.pager.shop.response.Response;

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
     *
     * @param request 请求参数
     * @return 分类列表
     */
    @PostMapping("/classification/list")
    public Response<List<GoodsClassificationResponse>> list(@RequestBody GoodsClassificationRequest request) {
        return goodsClassService.queryPage(request);

    }

    /**
     * 新增商品分类
     *
     * @param request 请求参数
     * @return 分类主键
     */
    @PostMapping("/classification/create")
    public Response<Long> create(@RequestBody GoodsClassificationSaveRequest request) {
        return goodsClassService.create(request);
    }

    /**
     * 商品分类修改
     *
     * @param request 请求参数
     * @return 分类主键
     */
    @PutMapping("/classification/modify")
    public Response<Long> modify(@RequestBody GoodsClassificationSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return goodsClassService.modify(request);
    }

    /**
     * 商品分类树形结构
     */
    @PostMapping("/classification/tree")
    public Response classificationTree() {
        return goodsClassService.classificationTree();
    }


}
