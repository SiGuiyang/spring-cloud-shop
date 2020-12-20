package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.goods.request.sku.GoodsSkuOtherRequest;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.user.response.Response;

/**
 * <p>
 * 商品sku 服务类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
public interface GoodsSkuService {

    /**
     * 商品sku集
     *
     * @param request 请求参数
     * @return 商品sku集
     */
    Response<List<GoodsSkuResponse>> queryList(final GoodsSkuOtherRequest request);

    /**
     * 通过sku主键或者sku编码 查询sku商品
     *
     * @param skuId   sku主键
     * @param skuCode skuCode sku编号
     * @return sku商品
     */
    Response<GoodsSkuResponse> querySku(final Long skuId, final String skuCode);
}
