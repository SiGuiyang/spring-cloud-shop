package quick.pager.shop.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.ClassificationDTO;
import quick.pager.shop.dto.GoodsDTO;
import quick.pager.shop.fallback.GoodsClientFallbackFactory;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.model.goods.Goods;

/**
 * 商品模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-goods", path = Constants.Module.GOODS, fallbackFactory = GoodsClientFallbackFactory.class)
public interface GoodsClient {

    /**
     * 商品列表
     */
    @RequestMapping(value = "/queryGoodsList", method = RequestMethod.POST)
    Response<List<Goods>> queryGoodsList(@RequestBody GoodsDTO request);

    /**
     * 商品新增
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    Response<String> addGoods(@RequestBody GoodsDTO request);

    /**
     * 商品修改
     */
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    Response<String> modifyGoods(@RequestBody GoodsDTO request);

    /**
     * 查看单个商品详情
     *
     * @param goodsId 商品Id
     */
    @RequestMapping(value = "/goodsInfo/{goodsId}", method = RequestMethod.POST)
    Response<GoodsResponse> goodsInfo(@PathVariable("goodsId") Long goodsId);

    /**
     * 商品分类列表
     *
     * @param className 分类名称
     */
    @RequestMapping(value = "/classification/list", method = RequestMethod.POST)
    Response classificationList(@RequestParam("className") String className);

    /**
     * 商品分类修改
     */
    @RequestMapping(value = "/classification/modify", method = RequestMethod.PUT)
    Response modifyClassification(@RequestBody ClassificationDTO dto);

    /**
     * 订单内的商品
     *
     * @param buyerOrderCartId 订单Id
     */
    @RequestMapping(value = "/buyer/order/{buyerOrderCartId}", method = RequestMethod.POST)
    Response<List<GoodsResponse>> queryBuyerOrderGoods(@PathVariable("buyerOrderCartId") Long buyerOrderCartId);


    /**
     * 用户购物车列表
     *
     * @param userId 用户Id
     */
    @RequestMapping(value = "/cart/list/{userId}", method = RequestMethod.POST)
    Response goodsCarts(@PathVariable("userId") Long userId);

    /**
     * 添加 | 删除购物车中的商品
     *
     * @param userId     用户Id
     * @param goodsIds   商品Id集
     * @param goodsCount 购买商品的数量
     * @param event      购买行为
     */
    @RequestMapping(value = "/cart/modify", method = RequestMethod.POST)
    Response modifyGoodsCart(@RequestParam("userId") Long userId, @RequestParam("goodsIds") Long[] goodsIds, @RequestParam("goodsCount") Integer goodsCount, @RequestParam("event") String event);
}
