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
import quick.pager.shop.manage.client.GoodsClient;
import quick.pager.shop.manage.request.ClassificationRequest;

@Api(description = "商品管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsController {

    @Autowired
    private GoodsClient goodsClient;

    @PostMapping("/goods/list")
    public Response goods() {
        return null;
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
