package quick.pager.shop.manage.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.fallback.GoodsClientFallback;
import quick.pager.shop.manage.request.ClassificationRequest;

/**
 * 商品模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-goods", fallback = GoodsClientFallback.class)
public interface GoodsClient {

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
