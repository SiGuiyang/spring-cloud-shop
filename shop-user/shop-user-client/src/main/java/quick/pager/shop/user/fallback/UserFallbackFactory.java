package quick.pager.shop.user.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.request.ManageRequest;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.user.client.UserClient;
import quick.pager.shop.user.request.UserRequest;
import quick.pager.shop.user.response.AddressResponse;
import quick.pager.shop.user.response.StationLetterResponse;
import quick.pager.shop.user.response.UserInfoResponse;

@Slf4j
@Component
public class UserFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable cause) {
        log.error("UserClient 进入熔断措施 msg = {}", cause.getMessage());
        return new UserClient() {
            @Override
            public Response<UserInfoResponse> getUser(Long userId) {
                log.error("进入熔断措施 UserClient.getUser");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<UserInfoResponse>> getBatchUser(UserRequest request) {
                log.error("进入熔断措施 UserClient.getBatchUser");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<UserInfoResponse>> isExists(UserRequest request) {
                log.error("进入熔断措施 UserClient.isExists");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<StationLetterResponse>> queryStationLetter(ManageRequest request) {
                log.error("进入熔断措施 UserClient.queryStationLetter");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<AddressResponse> address(Long addressId) {
                log.error("进入熔断措施 UserClient.queryAddress");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
