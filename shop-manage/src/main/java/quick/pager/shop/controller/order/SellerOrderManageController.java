package quick.pager.shop.controller.order;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.BindingResultUtils;
import quick.pager.shop.client.order.SellerOrderClient;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.order.SellerOrderDTO;

/**
 * 商家订单管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class SellerOrderManageController {

    @Autowired
    private SellerOrderClient sellerOrderClient;

    /**
     * 商户订单
     */
    @PostMapping("/order/seller")
    public Response sellerOrder(@Valid @RequestBody SellerOrderDTO request, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return sellerOrderClient.sellerOrders(request);
    }

    /**
     * 商户订单详情
     */
    @PostMapping("/order/seller/info")
    public Response sellerOrderInfo(@RequestParam("sellerOrderId") Long sellerOrderId) {
        return sellerOrderClient.sellerOrderInfo(sellerOrderId);
    }
}
