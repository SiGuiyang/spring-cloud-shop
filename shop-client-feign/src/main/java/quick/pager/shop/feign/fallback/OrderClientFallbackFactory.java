package quick.pager.shop.feign.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.client.OrderClient;
import quick.pager.shop.feign.dto.OrderDTO;
import quick.pager.shop.feign.dto.SellerOrderDTO;

@Slf4j
@Component
public class OrderClientFallbackFactory implements FallbackFactory<OrderClient> {
    @Override
    public OrderClient create(Throwable cause) {
        log.error("OrderClient 进入熔断错误异常信息 msg = {}", cause.getMessage());
        return new OrderClient() {
            @Override
            public Response orders(OrderDTO request) {
                log.error("进入熔断措施 OrderClient.orders");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response orderInfo(Long orderId) {
                log.error("进入熔断措施 OrderClient.orderInfo");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response sellerOrders(SellerOrderDTO request) {
                log.error("进入熔断措施 OrderClient.sellerOrders");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response sellerOrderInfo(Long sellerOrderId) {
                log.error("进入熔断措施 OrderClient.sellerOrderInfo");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
