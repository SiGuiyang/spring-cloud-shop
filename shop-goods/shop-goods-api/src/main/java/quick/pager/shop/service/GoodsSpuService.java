package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.goods.request.spu.GoodsSpuOtherRequest;
import quick.pager.shop.goods.request.spu.GoodsSpuPageRequest;
import quick.pager.shop.goods.request.spu.GoodsSpuSaveRequest;
import quick.pager.shop.goods.response.spu.GoodsSpuResponse;
import quick.pager.shop.goods.response.spu.GoodsSpuTreeResponse;
import quick.pager.shop.user.response.Response;

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
    Response<Long> create(final GoodsSpuSaveRequest request);

    /**
     * 编辑修改
     *
     * @param request 请求参数
     * @return spu主键
     */
    Response<Long> modify(final GoodsSpuSaveRequest request);

    /**
     * 删除
     *
     * @param id spu主键
     * @return spu主键
     */
    Response<Long> delete(final Long id);

    /**
     * 查询spu 分页
     *
     * @param request 请求参数
     * @return spu集
     */
    Response<List<GoodsSpuResponse>> queryPage(final GoodsSpuPageRequest request);

    /**
     * 查询spu集
     *
     * @param request 请求参数
     * @return spu集
     */
    Response<List<GoodsSpuResponse>> queryList(final GoodsSpuOtherRequest request);

    /**
     * spu分类树
     *
     * @return 数据响应
     */
    Response<List<GoodsSpuTreeResponse>> spuTree();
}
