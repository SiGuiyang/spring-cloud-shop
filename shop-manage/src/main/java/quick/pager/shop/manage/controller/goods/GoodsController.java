package quick.pager.shop.manage.controller.goods;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.client.GoodsClient;
import quick.pager.shop.feign.request.ClassificationRequest;
import quick.pager.shop.feign.request.GoodsRequest;
import quick.pager.shop.feign.response.GoodsResponse;

@Api(description = "商品管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsController {

    @Autowired
    private GoodsClient goodsClient;

    @PostMapping("/goods/list")
    public Response goods(GoodsRequest request) {
        return goodsClient.queryGoodsList(request);
    }

    @ApiOperation("商品新增|修改")
    @PostMapping("/goods/modify")
    public Response goodsModify(GoodsRequest request) {
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
    public Response modifyClassification(@RequestBody ClassificationRequest request) {
        return goodsClient.modifyGoodsClass(request);
    }
}
