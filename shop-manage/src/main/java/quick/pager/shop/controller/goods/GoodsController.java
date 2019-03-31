package quick.pager.shop.controller.goods;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.client.GoodsClient;
import quick.pager.shop.dto.ClassificationDTO;
import quick.pager.shop.dto.GoodsDTO;
import quick.pager.shop.response.GoodsResponse;

@Api(description = "商品管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsController {

    @Autowired
    private GoodsClient goodsClient;

    @PostMapping("/goods/list")
    public Response goods(GoodsDTO request) {
        return goodsClient.queryGoodsList(request);
    }

    @ApiOperation("商品新增|修改")
    @PostMapping("/goods/modify")
    public Response goodsModify(GoodsDTO request) {
        return goodsClient.modifyGoods(request);
    }

    @ApiOperation("查看商品详情")
    @PostMapping("/goods/info")
    public Response<GoodsResponse> goodsInfo(Long goodsId) {
        return goodsClient.goodsInfo(goodsId);
    }

    @ApiOperation("商品分类列表")
    @PostMapping("/goods/classification")
    public Response classification(String className) {
        return goodsClient.goodsClassList(className);
    }

    @ApiOperation("商品分类修改")
    @PostMapping("/goods/classification/modify")
    public Response modifyClassification(@RequestBody ClassificationDTO dto) {
        return goodsClient.modifyGoodsClass(dto);
    }
}
