package quick.pager.shop.manage.controller.goods;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;

@Api(description = "商品管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsController {

    @PostMapping("/goods/list")
    public Response goods() {
        return null;
    }

    @PostMapping("/goods/classification")
    public Response classification() {
        return null;
    }
}
