package quick.pager.shop.goods.service;

import java.util.List;
import quick.pager.shop.goods.model.GoodsBrand;
import quick.pager.shop.goods.request.brand.GoodsBrandPageRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IPageService;

/**
 * 商品品牌
 *
 * @author siguiyang
 */
public interface GoodsBrandService extends IPageService<GoodsBrand> {

    /**
     * 品牌列表
     */
    Response<List<GoodsBrand>> goodsBrandList(GoodsBrandPageRequest request);
}
