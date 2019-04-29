package quick.pager.shop.controller.goods;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.GoodsDTO;
import quick.pager.shop.service.goods.GoodsService;

@Api(description = "商品管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsManageController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/goods/list")
    public Response goods(GoodsDTO request) {
        return goodsService.queryGoodsList(request);
    }

    @ApiOperation("商品新增")
    @PostMapping("/goods/modify")
    public Response addGoods(GoodsDTO request) {
        return goodsService.addGoods(request);
    }

    @ApiOperation("商品修改")
    @PutMapping("/goods/modify")
    public Response modifyGoods(GoodsDTO request) {
        return goodsService.modifyGoods(request);
    }

    @ApiOperation("查看商品详情")
    @PostMapping("/goods/{goodsId}")
    public Response goodsInfo(@PathVariable("goodsId") Long goodsId) {
        return goodsService.goodsInfo(goodsId);
    }
}
