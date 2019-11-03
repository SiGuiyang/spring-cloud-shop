package quick.pager.shop.client;

import feign.hystrix.FallbackFactory;
import java.util.Set;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.dto.UserDTO;
import quick.pager.shop.resp.Response;

@FeignClient(value = "shop-manage", path = "/admin", fallbackFactory = AuthClient.AuthClientFactory.class)
public interface AuthClient {

    /**
     * 获取系统用户
     *
     * @param phone 手机号码
     */
    @RequestMapping(value = "/permit/sysUser", method = RequestMethod.POST)
    Response<UserDTO> getSysUser(@RequestParam("phone") String phone);

    /**
     * 根据系统用户Id查询此用户所拥有的角色
     *
     * @param sysUserId 系统用户Id
     */
    @RequestMapping(value = "/permit/permission/{sysUserId}", method = RequestMethod.POST)
    Response<Set<String>> getRolesBySysUserId(@PathVariable("sysUserId") Long sysUserId);

    /**
     * 熔断工厂
     */
    class AuthClientFactory implements FallbackFactory<AuthClient> {

        @Override
        public AuthClient create(Throwable cause) {
            return new AuthClient() {
                @Override
                public Response<UserDTO> getSysUser(String username) {
                    return new Response<>(3000, "网络连接错误，请稍后重试");
                }

                @Override
                public Response<Set<String>> getRolesBySysUserId(Long sysUserId) {
                    return new Response<>(3000, "网络连接错误，请稍后重试");
                }
            };
        }
    }
}
