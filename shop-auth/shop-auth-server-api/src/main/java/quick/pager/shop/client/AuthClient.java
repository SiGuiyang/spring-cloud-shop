package quick.pager.shop.client;

import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.model.UserDTO;
import quick.pager.shop.user.response.Response;

/**
 * 授权client
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-manage", path = "/admin", fallbackFactory = AuthClient.AuthClientFactory.class)
public interface AuthClient {

    /**
     * 获取系统用户
     *
     * @param phone 手机号码
     * @return 根据手机号码查询用户
     */
    @RequestMapping(value = "/permit/sysUser", method = RequestMethod.POST)
    Response<UserDTO> getSysUser(@RequestParam("phone") String phone);

    /**
     * 根据系统用户Id查询此用户所拥有的角色
     *
     * @param sysUserId 系统用户Id
     * @return 返回当前系统登陆用户拥有的权限
     */
    @RequestMapping(value = "/permit/permission/{sysUserId}", method = RequestMethod.POST)
    Response<List<String>> getRolesBySysUserId(@PathVariable("sysUserId") Long sysUserId);

    /**
     * 熔断工厂
     *
     * @author siguiyang
     */
    @Component
    class AuthClientFactory implements FallbackFactory<AuthClient> {

        @Override
        public AuthClient create(Throwable cause) {
            return new AuthClient() {
                @Override
                public Response<UserDTO> getSysUser(String username) {
                    return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, "网络连接错误，请稍后重试");
                }

                @Override
                public Response<List<String>> getRolesBySysUserId(Long sysUserId) {
                    return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, "网络连接错误，请稍后重试");
                }
            };
        }
    }
}
