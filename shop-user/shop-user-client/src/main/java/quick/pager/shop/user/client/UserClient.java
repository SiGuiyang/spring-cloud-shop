package quick.pager.shop.user.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.fallback.UserFallbackFactory;
import quick.pager.shop.user.request.UserRequest;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserProfileResponse;

/**
 * 用户模块
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.USER_CLIENT, path = ConstantsClient.USER, fallbackFactory = UserFallbackFactory.class)
public interface UserClient {

    /**
     * 获取用户信息
     *
     * @param userId 用户Id
     */
    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.POST)
    Response<UserProfileResponse> profile(@PathVariable("userId") Long userId);

    /**
     * 根据手机号码查询用户信息
     *
     * @param phone 手机号码
     * @return 用户信息
     */
    @RequestMapping(value = "/profile/{phone}/info", method = RequestMethod.POST)
    Response<UserProfileResponse> profileInfo(@PathVariable("phone") String phone);

    /**
     * 批量获取用户信息
     *
     * @param request 请求参数
     */
    @RequestMapping(value = "/batch/profile", method = RequestMethod.POST)
    Response<List<UserProfileResponse>> batchProfile(@RequestBody UserRequest request);
}
