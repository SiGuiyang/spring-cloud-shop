package quick.pager.shop.controller.app;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.param.GoodsSearchParam;
import quick.pager.shop.service.AppGoodsSkuService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;

/**
 * 商品SKU
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.GOODS)
public class AppGoodsSkuController {

    @Autowired
    private AppGoodsSkuService appGoodsSkuService;

    /**
     * 商品检索
     *
     * @param param 请求参数
     */
    @PostMapping("/app/sku/search")
    public Response search(@RequestBody GoodsSearchParam param) {

        Assert.isTrue(StringUtils.isNotEmpty(param.getKeyword()), () -> "请输入搜索关键字");
        return appGoodsSkuService.querySku(param);
    }

}
