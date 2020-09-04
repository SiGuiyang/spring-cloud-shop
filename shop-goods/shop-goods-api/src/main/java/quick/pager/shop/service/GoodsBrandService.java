package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.goods.request.brand.GoodsBrandPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandSaveRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品品牌
 *
 * @author siguiyang
 */
public interface GoodsBrandService {

    /**
     * 品牌列表
     *
     * @param request 分页请求参数
     * @return 数据响应
     */
    Response<List<GoodsBrandResponse>> queryPage(GoodsBrandPageRequest request);

    /**
     * 新增
     *
     * @param request 新增参数
     * @return 返回主键
     */
    Response<Long> create(GoodsBrandSaveRequest request);

    /**
     * 修改
     *
     * @param request 修改参数
     * @return 返回主键
     */
    Response<Long> modify(GoodsBrandSaveRequest request);
}
