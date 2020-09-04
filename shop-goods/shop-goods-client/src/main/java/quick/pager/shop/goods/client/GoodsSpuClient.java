package quick.pager.shop.goods.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.goods.fallback.GoodsSpuClientFallbackFactory;
import quick.pager.shop.goods.request.spu.GoodsSpuPageRequest;
import quick.pager.shop.goods.request.spu.GoodsSpuSaveRequest;
import quick.pager.shop.goods.response.spu.GoodsSpuResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品spu服务
 *
 * @author siguiyang
 * @version 3.0
 */
@FeignClient(value = ConstantsClient.GOODS_CLIENT, path = ConstantsClient.GOODS, fallbackFactory = GoodsSpuClientFallbackFactory.class)
public interface GoodsSpuClient {

    /**
     * 商品spu新增
     *
     * @param request 请求参数
     * @return 商品spu主键
     */
    @RequestMapping(value = "/spu/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody GoodsSpuSaveRequest request);

    /**
     * 商品spu修改
     *
     * @param request 请求参数
     * @return 商品spu主键
     */
    @RequestMapping(value = "/spu/modify", method = RequestMethod.PUT)
    Response<Long> modify(@RequestBody GoodsSpuSaveRequest request);

    /**
     * 商品spu列表 分页
     *
     * @param request 请求参数
     * @return 商品spu列表
     */
    @RequestMapping(value = "/spu/page", method = RequestMethod.POST)
    Response<List<GoodsSpuResponse>> queryPage(@RequestBody GoodsSpuPageRequest request);
}
