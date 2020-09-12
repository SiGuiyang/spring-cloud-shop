package quick.pager.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.elasticsearch.request.ESSellerOrderPageRequest;
import quick.pager.shop.elasticsearch.response.ESSellerOrderResponse;
import quick.pager.shop.service.SellerOrderService;
import quick.pager.shop.user.response.Response;

/**
 * 商户订单ES服务
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ELASTICSEARCH)
public class SellerOrderController {

    @Autowired
    private SellerOrderService sellerOrderService;

    /**
     * 订单查询
     *
     * @param request 请求参数
     */
    @PostMapping("/seller/order/page")
    public Response<List<ESSellerOrderResponse>> queryPage(@RequestBody final ESSellerOrderPageRequest request) {
        return sellerOrderService.queryPage(request);
    }
}
