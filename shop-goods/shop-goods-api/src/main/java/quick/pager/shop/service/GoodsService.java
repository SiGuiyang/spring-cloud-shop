package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.goods.request.GoodsApproveRequest;
import quick.pager.shop.model.Goods;
import quick.pager.shop.goods.request.GoodsPageRequest;
import quick.pager.shop.goods.request.GoodsSaveRequest;
import quick.pager.shop.goods.response.GoodsResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品主表信息
 *
 * @author siguiyang
 */
public interface GoodsService extends IService<Goods> {

    /**
     * 商品列表
     *
     * @param request 请求参数
     * @return 商品列表
     */
    Response<List<GoodsResponse>> queryPage(final GoodsPageRequest request);

    /**
     * 保存
     *
     * @param request 请求参数
     * @return 主键
     */
    Response<Long> create(final GoodsSaveRequest request);

    /**
     * 编辑
     *
     * @param request 请求参数
     * @return 主键
     */
    Response<Long> modify(final GoodsSaveRequest request);

    /**
     * sku 上下架状态更新
     *
     * @param skuId sku主键
     * @return 主键
     */
    Response<Long> state(final Long skuId);

    /**
     * sku 详情
     *
     * @param id 主键
     * @return 详情
     */
    Response<GoodsResponse> detail(final Long id);

    /**
     * 商品删除
     *
     * @param id 主键
     * @return 主键
     */
    Response<Long> delete(final Long id);

}
