package quick.pager.shop.goods.service;

import java.util.List;
import quick.pager.shop.goods.request.spu.GoodsSpuPageRequest;
import quick.pager.shop.goods.request.spu.GoodsSpuSaveRequest;
import quick.pager.shop.goods.response.spu.GoodsSpuResponse;
import quick.pager.shop.response.Response;

/**
 * <p>
 * 商品spu 服务类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
public interface GoodsSpuService {

    /**
     * 新增
     */
    Response<Long> create(GoodsSpuSaveRequest request);

    /**
     * 编辑修改
     */
    Response<Long> modify(GoodsSpuSaveRequest request);

    /**
     * 查询spu 分页
     */
    Response<List<GoodsSpuResponse>> queryPage(GoodsSpuPageRequest request);
}
