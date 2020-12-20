package quick.pager.shop.user.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.request.UserRequest;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserProfileResponse;
import quick.pager.shop.user.client.UserClient;

@Slf4j
@Component
public class UserFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable cause) {
        log.error("UserClient 进入熔断措施 msg = {}", cause.getMessage());
        return new UserClient() {
            @Override
            public Response<UserProfileResponse> profile(Long userId) {
                log.error("进入熔断措施 UserClient.profile");
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<UserProfileResponse> profileInfo(String phone) {
                log.error("进入熔断措施 UserClient.profileInfo");
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<UserProfileResponse>> batchProfile(UserRequest request) {
                log.error("进入熔断措施 UserClient.batchProfile");
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }
        };
    }
}
