package quick.pager.shop.manage.controller.order;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;

@Api(description = "售后")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class AfterSaleOrderController {

    @PostMapping("/order/after/sale")
    public Response afterSale() {
        return null;
    }
}
