package quick.pager.shop.user.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.response.Response;
import quick.pager.shop.user.fallback.UserFallbackFactory;
import quick.pager.shop.user.request.StationLetterRequest;
import quick.pager.shop.user.request.UserRequest;
import quick.pager.shop.user.response.AddressResponse;
import quick.pager.shop.user.response.StationLetterResponse;
import quick.pager.shop.user.response.UserInfoResponse;

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
    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.POST)
    Response<UserInfoResponse> getUser(@PathVariable("userId") Long userId);

    /**
     * 批量获取用户信息
     */
    @RequestMapping(value = "/batchUser/profile", method = RequestMethod.POST)
    Response<List<UserInfoResponse>> getBatchUser(@RequestBody UserRequest request);

    /**
     * 批量判断用户是否存在
     */
    @RequestMapping(value = "/isExists", method = RequestMethod.POST)
    Response<List<UserInfoResponse>> isExists(@RequestBody UserRequest request);

    /**
     * 查询站内信列表
     */
    @RequestMapping(value = "/queryStationLetter", method = RequestMethod.POST)
    Response<List<StationLetterResponse>> queryStationLetter(@RequestBody StationLetterRequest request);

    /**
     * 批量获取用户信息
     */
    @RequestMapping(value = "/address/{addressId}", method = RequestMethod.POST)
    Response<AddressResponse> address(@PathVariable("addressId") Long addressId);
}
