package quick.pager.shop.platform.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.platform.client.SystemConfigClient;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.request.SystemConfigSaveRequest;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.user.response.Response;

/**
 * 系统配置熔断
 *
 * @author siguiyang
 * @version 3.0
 */
@Component
@Slf4j
public class SystemConfigClientFallback implements FallbackFactory<SystemConfigClient> {
    @Override
    public SystemConfigClient create(Throwable cause) {
        return new SystemConfigClient() {
            @Override
            public Response<Long> create(SystemConfigSaveRequest request) {
                log.error("SystemConfigClient.create 进入熔断措施 msg = {}", cause.getMessage());
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<Long> modify(SystemConfigSaveRequest request) {
                log.error("SystemConfigClient.modify 进入熔断措施 msg = {}", cause.getMessage());
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<SystemConfigResponse>> queryList(SystemConfigOtherRequest request) {
                log.error("SystemConfigClient.queryList 进入熔断措施 msg = {}", cause.getMessage());
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<SystemConfigResponse>> queryPage(SystemConfigPageRequest request) {
                log.error("SystemConfigClient.queryPage 进入熔断措施 msg = {}", cause.getMessage());
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }
        };
    }
}
