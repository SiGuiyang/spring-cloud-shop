package quick.pager.shop.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.OrderDTO;
import quick.pager.shop.dto.SellerOrderDTO;
import quick.pager.shop.model.UserOrder;
import quick.pager.shop.response.Response;
import quick.pager.shop.client.OrderClient;

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

            @Override
            public Response orderCreate(UserOrder userOrder) {
                log.error("进入熔断措施 OrderClient.orderCreate");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
