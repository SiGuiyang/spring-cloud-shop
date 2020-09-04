package quick.pager.shop.goods.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.goods.fallback.GoodsBrandClientFallbackFactory;
import quick.pager.shop.goods.request.brand.GoodsBrandPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandSaveRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品 -> 品牌服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.GOODS_CLIENT, path = ConstantsClient.GOODS, fallbackFactory = GoodsBrandClientFallbackFactory.class)
public interface GoodsBrandClient {

    /**
     * 创建品牌
     *
     * @param request 请求参数
     * @return 品牌主键
     */
    @RequestMapping(value = "/brand/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody GoodsBrandSaveRequest request);

    /**
     * 修改品牌
     *
     * @param request 请求参数
     * @return 品牌主键
     */
    @RequestMapping(value = "/brand/modify", method = RequestMethod.POST)
    Response<Long> modify(@RequestBody GoodsBrandSaveRequest request);

    /**
     * 品牌列表
     *
     * @param request 请求参数
     * @return 品牌列表
     */
    @RequestMapping(value = "/brand/list", method = RequestMethod.POST)
    Response<List<GoodsBrandResponse>> list(@RequestBody GoodsBrandPageRequest request);
}
