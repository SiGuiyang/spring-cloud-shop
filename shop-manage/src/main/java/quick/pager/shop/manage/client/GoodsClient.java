package quick.pager.shop.manage.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.fallback.GoodsClientFallbackFactory;
import quick.pager.shop.manage.request.ClassificationRequest;
import quick.pager.shop.model.feign.request.GoodsRequest;
import quick.pager.shop.model.feign.response.GoodsResponse;
import quick.pager.shop.model.goods.Goods;

/**
 * 商品模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-goods", fallbackFactory = GoodsClientFallbackFactory.class)
public interface GoodsClient {

    /**
     * 商品列表
     */
    @RequestMapping(value = "/goods/queryGoodsList", method = RequestMethod.POST)
    Response<List<Goods>> queryGoodsList(@RequestBody GoodsRequest request);

    /**
     * 商品修改
     */
    @RequestMapping(value = "/goods/modifyGoods", method = RequestMethod.POST)
    Response<String> modifyGoods(@RequestBody GoodsRequest request);

    /**
     * 查看单个商品详情
     *
     * @param goodsId 商品Id
     */
    @RequestMapping(value = "/goods/goodsInfo/{goodsId}", method = RequestMethod.POST)
    Response<GoodsResponse> goodsInfo(@PathVariable("goodsId") Long goodsId);

    /**
     * 商品分类列表
     *
     * @param className 分类名称
     */
    @RequestMapping(value = "/goods/class/list", method = RequestMethod.POST)
    Response goodsClassList(@RequestParam("className") String className);

    /**
     * 商品分类修改
     */
    @RequestMapping(value = "/goods/class/modify", method = RequestMethod.POST)
    Response modifyGoodsClass(@RequestBody ClassificationRequest request);
}
