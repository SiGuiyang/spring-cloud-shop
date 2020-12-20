package quick.pager.shop.controller.app;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.goods.response.sku.AppGoodsSkuResponse;
import quick.pager.shop.service.AppClassificationService;
import quick.pager.shop.user.response.CommonResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品分类
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class AppClassificationController {

    @Autowired
    private AppClassificationService appClassificationService;

    /**
     * App 商品分类列表
     */
    @PostMapping("/app/spus")
    public Response<List<CommonResponse>> spus() {

        return appClassificationService.spus();
    }

    /**
     * App 商品分类列表
     *
     * @param spuId spu主键
     */
    @PostMapping("/app/classification/{spuId}")
    public Response<List<AppGoodsSkuResponse>> classification(@PathVariable("spuId") Long spuId) {

        return appClassificationService.classification(spuId);
    }
}
