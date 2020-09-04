package quick.pager.shop.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.order.fallback.SellerOrderClientFallbackFactory;
import quick.pager.shop.order.request.SellerOrderPageRequest;
import quick.pager.shop.order.request.SellerOrderSaveRequest;
import quick.pager.shop.user.response.Response;

/**
 * 商户订单模块
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ORDER_CLIENT, path = ConstantsClient.ORDER, fallbackFactory = SellerOrderClientFallbackFactory.class)
public interface SellerOrderClient {

    /**
     * 商户订单列表
     *
     * @param request 请求参数
     * @return 商户订单列表
     */
    @RequestMapping(value = "/seller/orders", method = RequestMethod.POST)
    Response sellerOrders(@RequestBody SellerOrderPageRequest request);

    /**
     * 商户订单详情
     *
     * @param sellerOrderId 商户订单主键
     * @return 商户订单详情
     */
    @RequestMapping(value = "/seller/{sellerOrderId}/order", method = RequestMethod.POST)
    Response sellerOrderInfo(@PathVariable("sellerOrderId") Long sellerOrderId);

    /**
     * 创建商户订单
     *
     * @param request 请求参数
     * @return 商户订单主键
     */
    @RequestMapping(value = "/seller/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody SellerOrderSaveRequest request);

    /**
     * 修改商户订单
     *
     * @param sellerOrder 订单
     * @return 商户订单主键
     */
    @RequestMapping(value = "/seller/mofidy", method = RequestMethod.PUT)
    Response<Long> modify(@RequestBody SellerOrderSaveRequest sellerOrder);
}
