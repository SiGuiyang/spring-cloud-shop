package quick.pager.shop.goods.controller.app;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;

/**
 * 商品分类
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class AppClassificationController {

    /**
     * App 商品分类列表
     *
     * @return
     */
    @GetMapping("/app/goods/classifications")
    public Response classifications() {

        return null;
    }
}
