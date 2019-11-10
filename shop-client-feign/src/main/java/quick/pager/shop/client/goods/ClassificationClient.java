package quick.pager.shop.client.goods;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.dto.goods.ClassificationDTO;
import quick.pager.shop.fallback.goods.ClassificationClientFallbackFactory;
import quick.pager.shop.response.Response;

/**
 * 商品 -> 分类服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.GOODS_CLIENT, path = ConstantsClient.GOODS, fallbackFactory = ClassificationClientFallbackFactory.class)
public interface ClassificationClient {

    /**
     * 商品分类列表
     */
    @RequestMapping(value = "/classification/list", method = RequestMethod.POST)
    Response list(@RequestBody ClassificationDTO dto);

    /**
     * 商品分类新增
     */
    @RequestMapping(value = "/classification/create", method = RequestMethod.POST)
    Response create(@RequestBody ClassificationDTO dto);

    /**
     * 商品分类修改
     */
    @RequestMapping(value = "/classification/modify", method = RequestMethod.POST)
    Response modify(@RequestBody ClassificationDTO dto);

    /**
     * 商品分类树形结构
     */
    @RequestMapping(value = "/classification/tree", method = RequestMethod.POST)
    Response tree();
}
