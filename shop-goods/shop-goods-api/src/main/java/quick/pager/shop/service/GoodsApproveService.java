package quick.pager.shop.service;

import quick.pager.shop.goods.request.GoodsApproveRequest;
import quick.pager.shop.goods.response.GoodsApproveResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品审核
 *
 * @author siguiyang
 */
public interface GoodsApproveService {

    /**
     * 商品审核创建
     *
     * @param request 请求参数
     * @return 主键
     */
    Response<Long> create(final GoodsApproveRequest request);

    /**
     * 商品审核详情
     *
     * @param skuId   sku主键
     * @param goodsId 商品主表主键
     * @return 主键
     */
    Response<GoodsApproveResponse> detail(final Long skuId, final Long goodsId);
}
