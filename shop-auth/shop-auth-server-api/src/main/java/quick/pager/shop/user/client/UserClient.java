package quick.pager.shop.user.client;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.user.response.Response;

/**
 * 用户信息
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-user", path = "/user", fallbackFactory = UserClient.UserClientFallbackFactory.class)
public interface UserClient {

    /**
     * 通过手机号码获取用户
     *
     * @param phone 手机号码
     */
    @RequestMapping(value = "getUserExists", method = RequestMethod.GET)
    Response<Boolean> getUserExists(@RequestParam("phone") String phone);

    @Component
    class UserClientFallbackFactory implements FallbackFactory<UserClient> {

        @Override
        public UserClient create(Throwable cause) {
            return null;
        }
    }
}
