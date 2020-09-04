package quick.pager.shop.user.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.request.UserRequest;
import quick.pager.shop.user.response.AddressResponse;
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
            public Response<UserProfileResponse> getUser(Long userId) {
                log.error("进入熔断措施 UserClient.getUser");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<UserProfileResponse>> getBatchUser(UserRequest request) {
                log.error("进入熔断措施 UserClient.getBatchUser");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<UserProfileResponse>> isExists(UserRequest request) {
                log.error("进入熔断措施 UserClient.isExists");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<AddressResponse> address(Long addressId) {
                log.error("进入熔断措施 UserClient.queryAddress");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
