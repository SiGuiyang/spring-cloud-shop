package quick.pager.shop.service.goods;

import quick.pager.shop.dto.goods.GoodsDTO;
import quick.pager.shop.response.Response;

/**
 * 商品服务
 *
 * @author siguiyang
 */
public interface GoodsService {
    /**
     * 商品列表
     */
    Response queryGoodsList(GoodsDTO request);

    /**
     * 添加商品
     */
    Response addGoods(GoodsDTO request);

    /**
     * 修改商品
     */
    Response modifyGoods(GoodsDTO request);

    /**
     * 商品详情
     *
     * @param goodsId 商品Id
     */
    Response goodsInfo(Long goodsId);
}
