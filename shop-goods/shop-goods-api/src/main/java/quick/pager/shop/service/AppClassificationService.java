package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.goods.response.sku.AppGoodsSkuResponse;
import quick.pager.shop.user.response.CommonResponse;
import quick.pager.shop.user.response.Response;

/**
 * APP 商品分类
 *
 * @author siguiyang
 */
public interface AppClassificationService {


    /**
     * 获取spu数据
     *
     * @return spu
     */
    Response<List<CommonResponse>> spus();

    /**
     * 分类列表
     */
    Response<List<AppGoodsSkuResponse>> classification(final Long spuId);
}
