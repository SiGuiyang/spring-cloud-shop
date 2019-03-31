package quick.pager.shop.client;

import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.dto.RoleDTO;
import quick.pager.shop.dto.UserDTO;
import quick.pager.shop.resp.Response;

@FeignClient(value = "shop-manage", path = "/admin", fallbackFactory = AuthClient.AuthClientFactory.class)
public interface AuthClient {

    /**
     * 获取系统用户
     *
     * @param username 用户名
     */
    @RequestMapping(value = "/permit/sysUser", method = RequestMethod.POST)
    Response<UserDTO> getSysUser(@RequestParam("username") String username);

    /**
     * 根据系统用户Id查询此用户所拥有的角色
     *
     * @param sysUserId 系统用户Id
     */
    @RequestMapping(value = "/permit/role/{sysUserId}", method = RequestMethod.POST)
    Response<List<RoleDTO>> getRolesBySysUserId(@PathVariable("sysUserId") Long sysUserId);

    /**
     * 熔断工厂
     */
    class AuthClientFactory implements FallbackFactory<AuthClient> {

        @Override
        public AuthClient create(Throwable cause) {
            return null;
        }
    }
}
