package quick.pager.shop.goods.service;

import java.util.List;
//import quick.pager.shop.param.goods.GoodsBrandGroupDTO;
import quick.pager.shop.goods.model.GoodsBrandGroup;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupPageRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IPageService;

/**
 * <p>
 * 品牌组 服务类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
public interface GoodsBrandGroupService extends IPageService<GoodsBrandGroup> {

    /**
     * 商品品牌组列表
     */
    Response<List<GoodsBrandGroup>> groupList(GoodsBrandGroupPageRequest request);
}
