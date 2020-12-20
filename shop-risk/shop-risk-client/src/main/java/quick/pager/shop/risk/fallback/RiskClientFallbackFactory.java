package quick.pager.shop.risk.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import quick.pager.shop.risk.request.WhiteBlacklistPageRequest;
import quick.pager.shop.risk.client.RiskClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.risk.request.WhiteBlacklistSaveRequest;

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
            public Response queryList(WhiteBlacklistPageRequest request) {
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<Long> create(WhiteBlacklistSaveRequest request) {
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<Long> modify(WhiteBlacklistSaveRequest request) {
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<Long> delete(Long id) {
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
