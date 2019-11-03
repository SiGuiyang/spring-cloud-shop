package quick.pager.shop.client.goods;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.dto.goods.GoodsBrandGroupDTO;
import quick.pager.shop.model.goods.GoodsBrandGroup;
import quick.pager.shop.response.Response;

/**
 * 商品组对外服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.GOODS_CLIENT, path = ConstantsClient.GOODS)
public interface GoodsBrandGroupClient {

    /**
     * 新建商品品牌组
     */
    @RequestMapping(value = "/brand/group/create", method = RequestMethod.POST)
    Response create(@RequestBody GoodsBrandGroupDTO dto);

    /**
     * 修改商品品牌组
     */
    @RequestMapping(value = "/brand/group/modify", method = RequestMethod.POST)
    Response modify(@RequestBody GoodsBrandGroupDTO dto);

    /**
     * 商品品牌组列表
     */
    @RequestMapping(value = "/brand/group/list", method = RequestMethod.POST)
    Response<List<GoodsBrandGroup>> list(@RequestBody GoodsBrandGroupDTO dto);

    /**
     * 商品品牌组所有列表
     */
    @RequestMapping(value = "/brand/group/listAll", method = RequestMethod.POST)
    Response<List<GoodsBrandGroup>> listAll();
}
