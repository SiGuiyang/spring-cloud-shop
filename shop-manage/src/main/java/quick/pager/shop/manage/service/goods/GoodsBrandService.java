package quick.pager.shop.manage.service.goods;

import java.util.List;
import quick.pager.shop.goods.response.brand.GoodsBrandResponse;
import quick.pager.shop.manage.param.goods.GoodsBrandPageParam;
import quick.pager.shop.manage.param.goods.GoodsBrandSaveParam;
import quick.pager.shop.response.Response;

/**
 * 商品品牌
 *
 * @author siguiyang
 */
public interface GoodsBrandService {

    /**
     * 品牌列表
     */
    Response<List<GoodsBrandResponse>> list(GoodsBrandPageParam param);

    /**
     * 新增品牌
     */
    Response create(GoodsBrandSaveParam param);

    /**
     * 修改品牌
     */
    Response modify(GoodsBrandSaveParam param);
}
