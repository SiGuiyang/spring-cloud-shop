package quick.pager.shop.goods.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.goods.fallback.ClassificationClientFallbackFactory;
import quick.pager.shop.goods.request.classification.GoodsClassificationPageRequest;
import quick.pager.shop.goods.request.classification.GoodsClassificationSaveRequest;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品 -> 分类服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.GOODS_CLIENT, path = ConstantsClient.GOODS, fallbackFactory = ClassificationClientFallbackFactory.class)
public interface ClassificationClient {

    /**
     * 商品分类列表
     *
     * @param request 请求参数
     * @return 商品分类列表
     */
    @RequestMapping(value = "/classification/list", method = RequestMethod.POST)
    Response<List<GoodsClassificationResponse>> list(@RequestBody GoodsClassificationPageRequest request);

    /**
     * 商品分类新增
     *
     * @param request 请求参数
     * @return 商品分类主键
     */
    @RequestMapping(value = "/classification/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody GoodsClassificationSaveRequest request);

    /**
     * 商品分类修改
     *
     * @param request 请求参数
     * @return 商品分类主键
     */
    @RequestMapping(value = "/classification/modify", method = RequestMethod.POST)
    Response<Long> modify(@RequestBody GoodsClassificationSaveRequest request);

    /**
     * 商品分类树形结构
     *
     * @return 商品分类树形结构
     */
    @RequestMapping(value = "/classification/tree", method = RequestMethod.POST)
    Response tree();
}
