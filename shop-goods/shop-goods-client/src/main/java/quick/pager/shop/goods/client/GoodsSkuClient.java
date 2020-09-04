package quick.pager.shop.goods.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.goods.fallback.GoodsSkuClientFallbackFactory;
import quick.pager.shop.goods.request.sku.GoodsSkuOtherRequest;
import quick.pager.shop.goods.request.sku.GoodsSkuPageRequest;
import quick.pager.shop.goods.request.sku.GoodsSkuSaveRequest;
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
     * 商品sku新增
     *
     * @param request 请求参数
     * @return 商品sku主键
     */
    @RequestMapping(value = "/sku/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody GoodsSkuSaveRequest request);

    /**
     * 商品sku修改
     *
     * @param request 请求参数
     * @return 商品sku主键
     */
    @RequestMapping(value = "/sku/modify", method = RequestMethod.PUT)
    Response<Long> modify(@RequestBody GoodsSkuSaveRequest request);

    /**
     * 商品sku列表
     *
     * @param request 请求参数
     * @return 商品sku列表
     */
    @RequestMapping(value = "/sku/page", method = RequestMethod.POST)
    Response<List<GoodsSkuResponse>> queryPage(@RequestBody GoodsSkuPageRequest request);

    /**
     * 商品sku集
     *
     * @param request 请求参数
     * @return 商品sku集
     */
    @RequestMapping(value = "sku/list", method = RequestMethod.POST)
    Response<List<GoodsSkuResponse>> queryList(@RequestBody GoodsSkuOtherRequest request);
}
