package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.goods.request.GoodsApproveRequest;
import quick.pager.shop.goods.response.GoodsApproveResponse;
import quick.pager.shop.service.GoodsApproveService;
import quick.pager.shop.user.response.Response;

/**
 * 商品审核
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.GOODS)
public class GoodsApproveController {

    @Autowired
    private GoodsApproveService goodsApproveService;

    /**
     * 商品审核创建
     *
     * @param request 请求参数
     * @return 主键
     */
    @PostMapping("/sku/approve/create")
    public Response<Long> create(@RequestBody GoodsApproveRequest request) {

        return goodsApproveService.create(request);
    }


    /**
     * 商品审核详情
     *
     * @param skuId   sku主键
     * @param goodsId 商品主表主键
     * @return 主键
     */
    @GetMapping("/sku/approve/{skuId}/detail/{goodsId}")
    public Response<GoodsApproveResponse> detail(@PathVariable("skuId") Long skuId, @PathVariable("goodsId") Long goodsId) {

        return goodsApproveService.detail(skuId, goodsId);
    }
}
