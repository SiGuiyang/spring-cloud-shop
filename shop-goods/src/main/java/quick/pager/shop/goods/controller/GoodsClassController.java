package quick.pager.shop.goods.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.goods.service.GoodsClassService;

/**
 * 商品分类
 *
 * @author siguiyang
 */
@Api(description = "商品分类")
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsClassController {

    @Autowired
    private GoodsClassService goodsClassService;

    @ApiOperation("商品分类列表")
    @PostMapping("/class/list")
    public Response goodsClassList() {
        return goodsClassService.doService(null);
    }
}
