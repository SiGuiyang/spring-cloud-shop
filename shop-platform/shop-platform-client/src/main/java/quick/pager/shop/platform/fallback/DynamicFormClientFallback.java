package quick.pager.shop.platform.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.platform.client.DynamicFormClient;
import quick.pager.shop.platform.request.DynamicFormSaveRequest;
import quick.pager.shop.platform.response.DynamicFormResponse;
import quick.pager.shop.user.response.Response;

@Component
@Slf4j
public class DynamicFormClientFallback implements FallbackFactory<DynamicFormClient> {
    @Override
    public DynamicFormClient create(Throwable cause) {
        log.error("DynamicFormClient 进入熔断措施 msg = {}", cause.getMessage());
        return new DynamicFormClient() {
            @Override
            public Response<Long> create(DynamicFormSaveRequest request) {
                log.error("DynamicFormClient.create 进入熔断措施 msg = {}", cause.getMessage());
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<Long> modify(DynamicFormSaveRequest request) {
                log.error("DynamicFormClient.modify 进入熔断措施 msg = {}", cause.getMessage());
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<DynamicFormResponse>> get(String bizType) {
                log.error("DynamicFormClient.get 进入熔断措施 msg = {}", cause.getMessage());
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }
        };
    }
}
