package quick.pager.shop.client.goods;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.dto.goods.GoodsBrandDTO;
import quick.pager.shop.response.Response;

/**
 * 商品 -> 品牌服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.GOODS_CLIENT, path = ConstantsClient.GOODS)
public interface GoodsBrandClient {

    /**
     * 创建品牌
     */
    @RequestMapping(value = "/brand/create", method = RequestMethod.POST)
    Response create(@RequestBody GoodsBrandDTO dto);

    /**
     * 修改品牌
     */
    @RequestMapping(value = "/brand/modify", method = RequestMethod.POST)
    Response modify(@RequestBody GoodsBrandDTO dto);

    /**
     * 品牌列表
     */
    @RequestMapping(value = "/brand/list", method = RequestMethod.POST)
    Response<List<GoodsBrandDTO>> list(@RequestBody GoodsBrandDTO dto);
}
