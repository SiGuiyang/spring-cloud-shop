package quick.pager.shop.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.fallback.UserAccountFallbackFactory;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserAccountResponse;

/**
 * 用户账户信息
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.USER_CLIENT, path = ConstantsClient.USER, fallbackFactory = UserAccountFallbackFactory.class)
public interface UserAccountClient {

    /**
     * 根据用户主键查询用户账户信息
     *
     * @param userId 用户主键
     * @return 户账户信息
     */
    @RequestMapping(value = "/account/{userId}", method = RequestMethod.POST)
    Response<UserAccountResponse> account(@PathVariable("userId") Long userId);

}
