package quick.pager.shop.goods.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.goods.fallback.GoodsSkuClientFallbackFactory;
import quick.pager.shop.goods.request.sku.GoodsSkuOtherRequest;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品sku服务
 *
 * @author siguiyang
 * @version 3.0
 */
@FeignClient(value = ConstantsClient.GOODS_CLIENT, path = ConstantsClient.GOODS, fallbackFactory = GoodsSkuClientFallbackFactory.class)
public interface GoodsSkuClient {
    /**
     * 商品sku集
     *
     * @param request 请求参数
     * @return 商品sku集
     */
    @RequestMapping(value = "sku/list", method = RequestMethod.POST)
    Response<List<GoodsSkuResponse>> queryList(@RequestBody GoodsSkuOtherRequest request);

    /**
     * 通过sku主键或者sku编码 查询sku商品
     *
     * @param skuId   sku主键
     * @param skuCode skuCode sku编号
     * @return sku商品
     */
    @RequestMapping(value = "/sku/query", method = RequestMethod.POST)
    Response<GoodsSkuResponse> querySku(@RequestParam(value = "skuId", required = false) Long skuId,
                                        @RequestParam(value = "skuCode", required = false) String skuCode);
}
