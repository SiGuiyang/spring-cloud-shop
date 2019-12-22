package quick.pager.shop.manage.controller.order;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.order.request.SellerOrderPageRequest;
import quick.pager.shop.response.Response;

/**
 * 商家订单管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class SellerOrderManageController {


    /**
     * 商户订单
     */
    @PostMapping("/order/seller")
    public Response sellerOrder(@Valid @RequestBody SellerOrderPageRequest request) {
        return null;
    }

    /**
     * 商户订单详情
     */
    @PostMapping("/order/seller/info")
    public Response sellerOrderInfo(@RequestParam("sellerOrderId") Long sellerOrderId) {
        return null;
    }
}
