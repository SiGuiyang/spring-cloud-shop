package quick.pager.shop.goods.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.goods.fallback.GoodsBrandGroupClientFallbackFactory;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupSaveRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandGroupResponse;
import quick.pager.shop.response.Response;

/**
 * 商品组对外服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.GOODS_CLIENT, path = ConstantsClient.GOODS, fallbackFactory = GoodsBrandGroupClientFallbackFactory.class)
public interface GoodsBrandGroupClient {

    /**
     * 新建商品品牌组
     *
     * @param request 请求参数
     * @return 品牌组主键
     */
    @RequestMapping(value = "/brand/group/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody GoodsBrandGroupSaveRequest request);

    /**
     * 修改商品品牌组
     *
     * @param request 请求参数
     * @return 品牌组主键
     */
    @RequestMapping(value = "/brand/group/modify", method = RequestMethod.POST)
    Response<Long> modify(@RequestBody GoodsBrandGroupSaveRequest request);

    /**
     * 商品品牌组列表
     *
     * @param request 请求参数
     * @return 品牌组列表
     */
    @RequestMapping(value = "/brand/group/list", method = RequestMethod.POST)
    Response<List<GoodsBrandGroupResponse>> list(@RequestBody GoodsBrandGroupPageRequest request);

    /**
     * 商品品牌组所有列表
     *
     * @return 品牌组列表
     */
    @RequestMapping(value = "/brand/group/listAll", method = RequestMethod.POST)
    Response<List<GoodsBrandGroupResponse>> listAll();
}
