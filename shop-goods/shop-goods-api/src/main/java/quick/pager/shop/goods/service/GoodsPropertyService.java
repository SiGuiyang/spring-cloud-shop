package quick.pager.shop.goods.service;

import java.util.List;
import quick.pager.shop.goods.model.GoodsProperty;
import quick.pager.shop.goods.request.property.GoodsPropertyPageRequest;
import quick.pager.shop.goods.request.property.GoodsPropertySaveRequest;
import quick.pager.shop.goods.response.property.GoodsPropertyResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;

/**
 * <p>
 * 商品属性 服务类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
public interface GoodsPropertyService extends IService<GoodsProperty> {

    /**
     * 商品属性分页
     *
     * @param request 请求参数
     * @return 数据响应
     */
    Response<List<GoodsPropertyResponse>> queryPage(GoodsPropertyPageRequest request);

    /**
     * 新增
     *
     * @param request 请求参数
     * @return 数据响应
     */
    Response<Long> create(GoodsPropertySaveRequest request);

    /**
     * 修改
     *
     * @param request 请求参数
     * @return 数据响应
     */
    Response<Long> modify(GoodsPropertySaveRequest request);
}
