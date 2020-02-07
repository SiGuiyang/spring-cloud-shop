package quick.pager.shop.manage.controller.order;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;

/**
 * 售后服务
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class AfterSaleOrderController {

    @PostMapping("/order/after/sale")
    @PreAuthorize("hasAuthority('PAGER_ORDER_SALE')")
    public Response afterSale() {
        return null;
    }
}
