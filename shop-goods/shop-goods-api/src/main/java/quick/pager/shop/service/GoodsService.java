package quick.pager.shop.service;

import java.util.List;
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
     * 保存
     *
     * @param request 请求参数
     * @return 主键
     */
    Response<Long> create(GoodsSaveRequest request);

    /**
     * 编辑
     *
     * @param request 请求参数
     * @return 主键
     */
    Response<Long> modify(GoodsSaveRequest request);

    /**
     * 商品列表
     *
     * @param request 请求参数
     * @return 商品列表
     */
    Response<List<GoodsResponse>> queryPage(GoodsPageRequest request);
}
