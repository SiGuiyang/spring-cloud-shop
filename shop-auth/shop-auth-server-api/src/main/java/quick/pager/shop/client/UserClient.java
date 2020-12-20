package quick.pager.shop.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;

/**
 * 用户模块
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.USER_CLIENT, path = ConstantsClient.USER, fallbackFactory = UserClient.UserFallbackFactory.class)
public interface UserClient {

    /**
     * sms短信登录
     * 用户不存在则自动注册，并返回登录信息
     *
     * @param phone 手机号码
     * @return 用户信息
     */
    @RequestMapping(value = "/app/login/sms", method = RequestMethod.POST)
    Response<AppUserProfileDTO> login(@RequestParam("phone") String phone);

    @Slf4j
    class UserFallbackFactory implements FallbackFactory<UserClient> {

        @Override
        public UserClient create(Throwable cause) {
            return phone -> {
                log.error("短信登录熔断 phone = {}", phone);
                return Response.toError(ResponseStatus.TELNET_EXCEPTION);
            };
        }
    }
}
