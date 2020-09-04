package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.goods.request.sku.GoodsSkuOtherRequest;
import quick.pager.shop.goods.request.sku.GoodsSkuPageRequest;
import quick.pager.shop.goods.request.sku.GoodsSkuSaveRequest;
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
     * 新增
     */
    Response<Long> create(final GoodsSkuSaveRequest request);

    /**
     * 编辑修改
     */
    Response<Long> modify(final GoodsSkuSaveRequest request);

    /**
     * 列表分页
     */
    Response<List<GoodsSkuResponse>> queryPage(final GoodsSkuPageRequest request);

    /**
     * 商品sku集
     *
     * @param request 请求参数
     * @return 商品sku集
     */
    Response<List<GoodsSkuResponse>> queryList(final GoodsSkuOtherRequest request);
}
