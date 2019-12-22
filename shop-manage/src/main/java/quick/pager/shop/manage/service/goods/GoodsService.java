package quick.pager.shop.manage.service.goods;

import quick.pager.shop.manage.param.goods.GoodsPageParam;
import quick.pager.shop.manage.param.goods.GoodsSaveParam;
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
    Response queryGoodsList(GoodsPageParam param);

    /**
     * 添加商品
     */
    Response addGoods(GoodsSaveParam param);

    /**
     * 修改商品
     */
    Response modifyGoods(GoodsSaveParam param);

    /**
     * 商品详情
     *
     * @param goodsId 商品Id
     */
    Response goodsInfo(Long goodsId);
}
