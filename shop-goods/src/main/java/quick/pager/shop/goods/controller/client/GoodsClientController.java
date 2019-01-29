package quick.pager.shop.goods.controller.client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.dto.GoodsDTO;
import quick.pager.shop.feign.response.GoodsResponse;
import quick.pager.shop.goods.service.client.GoodsClientService;
import quick.pager.shop.model.goods.Goods;

/**
 * 暴露feign的服务
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsClientController {

    @Autowired
    private GoodsClientService goodsClientService;

    @RequestMapping(value = "/queryGoodsList", method = RequestMethod.POST)
    public Response<List<Goods>> queryGoodsList(@RequestBody GoodsDTO request) {
        return goodsClientService.queryGoodsList(request);
    }

    /**
     * 商品修改
     */
    @RequestMapping(value = "/modifyGoods", method = RequestMethod.POST)
    public Response<String> modifyGoods(@RequestBody GoodsDTO request) {
        return goodsClientService.modifyGoods(request);
    }

    /**
     * 获取商品详细
     */
    @RequestMapping(value = "/queryBuyerOrderGoods/{buyerOrderCartId}", method = RequestMethod.POST)
    public Response<List<GoodsResponse>> queryBuyerOrderGoods(@PathVariable("buyerOrderCartId") Long buyerOrderCartId) {

        return goodsClientService.queryBuyerOrderGoods(buyerOrderCartId);
    }
}
