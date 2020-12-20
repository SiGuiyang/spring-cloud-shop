package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.goods.request.classification.GoodsClassificationPageRequest;
import quick.pager.shop.goods.request.classification.GoodsClassificationSaveRequest;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.user.response.Response;

/**
 * <p>
 * 商品分类 服务类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
public interface GoodsClassService {

    /**
     * 新增
     *
     * @param request 请求参数
     * @return 数据响应
     */
    Response<Long> create(final GoodsClassificationSaveRequest request);

    /**
     * 编辑
     */
    Response<Long> modify(final GoodsClassificationSaveRequest request);

    /**
     * 删除
     *
     * @param id 主键
     * @return 数据响应
     */
    Response<Long> delete(final Long id);

    /**
     * 获取分类列表分页
     *
     * @param request 请求参数
     * @return 数据响应
     */
    Response<List<GoodsClassificationResponse>> queryPage(final GoodsClassificationPageRequest request);

    /**
     * 根据spuId查询商品分类
     *
     * @param spuId spu主键
     * @return 数据响应
     */
    Response<List<GoodsClassificationResponse>> queryBySpuId(final Long spuId);
}
