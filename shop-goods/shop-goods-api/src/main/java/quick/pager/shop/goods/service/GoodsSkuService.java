package quick.pager.shop.goods.service;

import java.util.List;
import quick.pager.shop.goods.request.sku.GoodsSkuPageRequest;
import quick.pager.shop.goods.request.sku.GoodsSkuSaveRequest;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.response.Response;

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
    Response<Long> create(GoodsSkuSaveRequest request);

    /**
     * 编辑修改
     */
    Response<Long> modify(GoodsSkuSaveRequest request);

    /**
     * 列表分页
     */
    Response<List<GoodsSkuResponse>> queryPage(GoodsSkuPageRequest request);
}
