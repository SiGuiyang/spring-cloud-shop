package quick.pager.shop.goods.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.common.response.Response;
import quick.pager.shop.goods.fallback.UserFallbackFactory;
import quick.pager.shop.model.feign.dto.UserInfoDTO;

/**
 * 用户模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-user", path = "/user", fallbackFactory = UserFallbackFactory.class)
public interface UserClient {

    /**
     * 获取用户信息
     *
     * @param userId 用户Id
     */
    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.POST)
    Response<UserInfoDTO> getUser(@PathVariable("userId") Long userId);

}
