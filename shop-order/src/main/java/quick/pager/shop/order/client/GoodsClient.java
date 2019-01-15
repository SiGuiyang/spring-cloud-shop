package quick.pager.shop.order.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.common.response.Response;
import quick.pager.shop.model.feign.response.GoodsResponse;
import quick.pager.shop.order.fallback.GoodsFallback;

/**
 * 商品模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-goods", fallback = GoodsFallback.class)
public interface GoodsClient {


    @RequestMapping(value = "/goods/queryBuyerOrderGoods/{buyerOrderCartId}", method = RequestMethod.POST)
    Response<List<GoodsResponse>> queryBuyerOrderGoods(@PathVariable("buyerOrderCartId") Long buyerOrderCartId);
}
