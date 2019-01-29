package quick.pager.shop.feign.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.request.ManageRequest;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.client.UserClient;
import quick.pager.shop.feign.dto.UserInfoDTO;
import quick.pager.shop.model.common.Address;
import quick.pager.shop.model.user.StationLetter;

@Slf4j
@Component
public class UserFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable cause) {
        log.error("UserClient 进入熔断措施 msg = {}", cause.getMessage());
        return new UserClient() {
            @Override
            public Response<UserInfoDTO> getUser(Long userId) {
                log.error("进入熔断措施 UserClient.getUser");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<UserInfoDTO>> getBatchUser(Long[] userIds) {
                log.error("进入熔断措施 UserClient.getBatchUser");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<UserInfoDTO>> isExists(String[] phones) {
                log.error("进入熔断措施 UserClient.isExists");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<StationLetter>> queryStationLetter(ManageRequest request) {
                log.error("进入熔断措施 UserClient.queryStationLetter");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<Address> queryAddress(Long addressId) {
                log.error("进入熔断措施 UserClient.queryAddress");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
