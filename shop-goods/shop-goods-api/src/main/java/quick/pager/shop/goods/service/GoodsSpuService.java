package quick.pager.shop.goods.service;

import java.util.List;
import quick.pager.shop.goods.model.GoodsSpu;
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
     *
     * @param request 请求参数
     * @return spu主键
     */
    Response<Long> create(GoodsSpuSaveRequest request);

    /**
     * 编辑修改
     *
     * @param request 请求参数
     * @return spu主键
     */
    Response<Long> modify(GoodsSpuSaveRequest request);

    /**
     * 查询spu 分页
     *
     * @param request 请求参数
     * @return spu集
     */
    Response<List<GoodsSpuResponse>> queryPage(GoodsSpuPageRequest request);
}
