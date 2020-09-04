package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.param.GoodsSearchParam;
import quick.pager.shop.goods.response.GoodsResponse;
import quick.pager.shop.user.response.Response;

/**
 * APP 商品检索服务
 *
 * @author siguiyang
 */
public interface AppGoodsSkuService {


    /**
     * 商品检索
     *
     * @param param 检索参数
     */
    Response<List<GoodsResponse>> querySku(final GoodsSearchParam param);
}
