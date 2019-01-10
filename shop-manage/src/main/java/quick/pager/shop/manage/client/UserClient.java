package quick.pager.shop.manage.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.fallback.UserClientFallback;
import quick.pager.shop.model.feign.dto.UserInfoDTO;
import quick.pager.shop.model.user.User;

/**
 * 用户模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-user", fallback = UserClientFallback.class)
public interface UserClient {

    /**
     * 获取用户信息
     *
     * @param userId 用户Id
     * @return
     */
    @RequestMapping(value = "/user/getUser/{userId}", method = RequestMethod.POST)
    Response<User> getUser(@PathVariable("userId") Long userId);

    /**
     * 批量获取用户信息
     */
    @RequestMapping(value = "/user/batchUser/profile")
    Response<List<UserInfoDTO>> getBatchUser(@RequestParam("userIds") Long[] userIds);
}
