package quick.pager.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.goods.request.sku.GoodsSkuOtherRequest;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.service.GoodsSkuService;
import quick.pager.shop.user.response.Response;

/**
 * 商品sku
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsSkuController {

    @Autowired
    private GoodsSkuService goodsSkuService;

    /**
     * 商品sku集
     *
     * @param request 请求参数
     * @return 商品sku集
     */
    @PostMapping("/sku/list")
    public Response<List<GoodsSkuResponse>> queryList(@RequestBody GoodsSkuOtherRequest request) {

        return goodsSkuService.queryList(request);
    }


    /**
     * 通过sku主键或者sku编码 查询sku商品
     *
     * @param skuId   sku主键
     * @param skuCode skuCode sku编号
     * @return sku商品
     */
    @PostMapping("/sku/query")
    public Response<GoodsSkuResponse> querySku(@RequestParam(value = "skuId", required = false) Long skuId,
                                               @RequestParam(value = "skuCode", required = false) String skuCode) {
        return goodsSkuService.querySku(skuId, skuCode);
    }
}
