package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.request.GoodsPageRequest;
import quick.pager.shop.goods.request.GoodsSaveRequest;
import quick.pager.shop.goods.response.GoodsResponse;
import quick.pager.shop.service.GoodsService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;

/**
 * 商品主表信息
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品列表
     *
     * @param request 请求参数
     * @return 商品列表
     */
    @PostMapping("/product/page")
    public Response<List<GoodsResponse>> page(@RequestBody GoodsPageRequest request) {
        return goodsService.queryPage(request);
    }

    /**
     * 保存
     *
     * @param request 请求参数
     * @return 主键
     */
    @PostMapping("/product/create")
    public Response<Long> create(@RequestBody GoodsSaveRequest request) {
        return goodsService.create(request);
    }

    /**
     * 编辑
     *
     * @param request 请求参数
     * @return 主键
     */
    @PutMapping("/product/modify")
    public Response<Long> modify(@RequestBody GoodsSaveRequest request) {
        Assert.isTrue(Objects.nonNull(request.getId()), () -> ResponseStatus.PARAMS_EXCEPTION);

        return goodsService.modify(request);
    }

    /**
     * 商品sku上下架状态更新
     *
     * @param skuId sku主键
     * @return 主键
     */
    @PostMapping("/product/state/{skuId}")
    public Response<Long> state(@PathVariable("skuId") Long skuId) {
        return goodsService.state(skuId);
    }

    /**
     * 商品详情
     *
     * @param id 主键
     * @return 商品详情
     */
    @GetMapping("/product/{id}")
    public Response<GoodsResponse> detail(@PathVariable("id") Long id) {

        return goodsService.detail(id);
    }

    /**
     * 商品删除
     *
     * @param id 主键
     * @return 主键
     */
    @DeleteMapping("/product/{id}")
    public Response<Long> delete(@PathVariable("id") Long id) {

        return goodsService.delete(id);
    }


}
