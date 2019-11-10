package quick.pager.shop.controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.goods.GoodsDTO;
import quick.pager.shop.service.goods.GoodsService;

/**
 * 商品管理
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsManageController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/goods/list")
    public Response goods(@RequestBody GoodsDTO request) {
        return goodsService.queryGoodsList(request);
    }

    /**
     * 商品新增
     */
    @PostMapping("/goods/modify")
    public Response addGoods(@RequestBody GoodsDTO request) {
        return goodsService.addGoods(request);
    }

    /**
     * 商品修改
     */
    @PutMapping("/goods/modify")
    public Response modifyGoods(@RequestBody GoodsDTO request) {
        return goodsService.modifyGoods(request);
    }

    /**
     * 查看商品详情
     */
    @PostMapping("/goods/{goodsId}")
    public Response goodsInfo(@PathVariable("goodsId") Long goodsId) {
        return goodsService.goodsInfo(goodsId);
    }
}
