package quick.pager.shop.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.order.fallback.SellerOrderClientFallbackFactory;
import quick.pager.shop.order.request.OrderTradeSaveRequest;
import quick.pager.shop.user.response.Response;

/**
 * 订单交易流水
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ORDER_CLIENT, path = ConstantsClient.ORDER, fallbackFactory = SellerOrderClientFallbackFactory.class)
public interface OrderTradeClient {

    /**
     * 交易流水新增
     *
     * @param request 请求参数
     * @return 返回数据
     */
    @RequestMapping(value = "/trade/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody OrderTradeSaveRequest request);
}
