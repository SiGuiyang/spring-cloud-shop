package quick.pager.shop.manage.controller.order;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;

/**
 * 商家订单管理
 *
 * @author siguiyang
 */
@Api(description = "商家订单管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class SellerOrderManageController {

    @PostMapping("/order/seller")
    public Response seller () {
        return null;
    }
}
