package quick.pager.shop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.response.Response;

/**
 * APP展示商品
 *
 * @author siguiyang
 */
@RestController
public class GoodsController {

    /**
     * 商品搜索
     */
    @RequestMapping(value = "/goods/search", method = RequestMethod.POST)
    public Response goodsSearch() {
        return null;
    }
}
