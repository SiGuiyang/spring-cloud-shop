package quick.pager.shop.order.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.shop.model.feign.response.GoodsResponse;
import quick.pager.shop.order.client.GoodsClient;

@Slf4j
@Component
public class GoodsClientFallbackFactory implements FallbackFactory<GoodsClient> {
    @Override
    public GoodsClient create(Throwable cause) {
        log.error("GoodsClient 进入熔断错误异常信息 msg = {}", cause.getMessage());
        return new GoodsClient() {
            @Override
            public Response<List<GoodsResponse>> queryBuyerOrderGoods(Long buyerOrderCartId) {
                log.error("进入熔断措施 GoodsClient.queryBuyerOrderGoods");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
