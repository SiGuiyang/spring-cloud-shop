package quick.pager.shop.goods.service;

import java.util.List;
import quick.pager.shop.goods.model.GoodsBrandGroup;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupSaveRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;

/**
 * <p>
 * 品牌组 服务类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
public interface GoodsBrandGroupService extends IService<GoodsBrandGroup> {

    /**
     * 新增
     *
     * @param request 请求参数
     * @return 品牌组主键
     */
    Response<Long> create(GoodsBrandGroupSaveRequest request);

    /**
     * 更新
     *
     * @param request 请求参数
     * @return 品牌组主键
     */
    Response<Long> modify(GoodsBrandGroupSaveRequest request);

    /**
     * 商品品牌组列表
     *
     * @param request 请求参数
     * @return 品牌组集
     */
    Response<List<GoodsBrandGroup>> queryPage(GoodsBrandGroupPageRequest request);
}
