package quick.pager.shop.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import quick.pager.shop.client.RiskClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BlackListDTO;
import quick.pager.shop.response.Response;

/**
 * 风控服务熔断
 *
 * @author siguiyang
 */
@Component
public class RiskClientFallbackFactory implements FallbackFactory<RiskClient> {
    @Override
    public RiskClient create(Throwable cause) {
        return new RiskClient() {
            @Override
            public Response getBlackLists(BlackListDTO dto) {
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response addBlackLists(BlackListDTO dto) {
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response modifyBlackLists(BlackListDTO dto) {
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response delBlackLists(Long id) {
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
