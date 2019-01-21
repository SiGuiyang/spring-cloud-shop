package quick.pager.shop.manage.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.request.ManageRequest;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.client.UserClient;
import quick.pager.shop.model.feign.dto.UserInfoDTO;
import quick.pager.shop.model.user.StationLetter;
import quick.pager.shop.model.user.User;

/**
 * 用户中心与商户中心模块熔断
 *
 * @author siguiyang
 */
@Slf4j
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable cause) {
        log.error("UserClient 进入熔断错误异常信息 msg = {}", cause.getMessage());
        return new UserClient() {
            @Override
            public Response<User> getUser(Long userId) {
                log.error("进入熔断措施 UserClient.getUser");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<List<UserInfoDTO>> getBatchUser(Long[] userIds) {
                log.error("进入熔断措施 UserClient.getBatchUser");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<List<StationLetter>> queryStationLetter(ManageRequest request) {
                log.error("进入熔断措施 UserClient.queryStationLetter");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
