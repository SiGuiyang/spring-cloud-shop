package quick.pager.shop.goods.service;

import java.util.List;
import quick.pager.shop.goods.request.classification.GoodsClassificationPageRequest;
import quick.pager.shop.goods.request.classification.GoodsClassificationSaveRequest;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.response.Response;

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
     * @return
     */
    Response<Long> create(GoodsClassificationSaveRequest request);

    /**
     * 编辑
     */
    Response<Long> modify(GoodsClassificationSaveRequest request);

    /**
     * 获取分类列表分页
     *
     * @param request 请求参数
     * @return 数据响应
     */
    Response<List<GoodsClassificationResponse>> queryPage(GoodsClassificationPageRequest request);

    /**
     * 商品树形结构
     */
    Response<List<GoodsClassificationResponse>> classificationTree();
}
