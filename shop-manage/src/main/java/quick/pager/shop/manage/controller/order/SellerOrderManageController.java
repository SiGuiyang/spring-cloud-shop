package quick.pager.shop.manage.controller.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.client.OrderClient;
import quick.pager.shop.feign.dto.SellerOrderDTO;

/**
 * 商家订单管理
 *
 * @author siguiyang
 */
@Api(description = "商家订单管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class SellerOrderManageController {

    @Autowired
    private OrderClient orderClient;

    @ApiOperation("商户订单")
    @PostMapping("/order/seller")
    public Response sellerOrder(SellerOrderDTO request) {
        return orderClient.sellerOrders(request);
    }

    @ApiOperation("商户订单详情")
    @PostMapping("/order/seller/info")
    public Response sellerOrderInfo(@RequestParam("sellerOrderId") Long sellerOrderId) {
        return orderClient.sellerOrderInfo(sellerOrderId);
    }
}
