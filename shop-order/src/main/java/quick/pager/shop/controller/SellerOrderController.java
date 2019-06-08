package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.model.order.SellerOrder;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.SellerOrderService;

@Api(description = "商户订单")
@RestController
public class SellerOrderController {

    @Autowired
    private SellerOrderService sellerOrderService;

    /**
     * 创建商户订单
     *
     * @param sellerOrder 订单
     */
    @ApiOperation("创建商户订单")
    @RequestMapping(value = "/seller/create", method = RequestMethod.POST)
    public Response sellerOrderCreate(@RequestBody SellerOrder sellerOrder) {

        return sellerOrderService.sellerOrderCreate(sellerOrder);
    }
}
