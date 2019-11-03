package quick.pager.shop.client.user;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.dto.user.UserInfoDTO;
import quick.pager.shop.fallback.user.UserFallbackFactory;
import quick.pager.shop.request.ManageRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.model.Address;
import quick.pager.shop.model.StationLetter;

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
    Response<UserInfoDTO> getUser(@PathVariable("userId") Long userId);

    /**
     * 批量获取用户信息
     */
    @RequestMapping(value = "/batchUser/profile")
    Response<List<UserInfoDTO>> getBatchUser(@RequestParam("userIds") Long[] userIds);

    /**
     * 批量判断用户是否存在
     */
    @RequestMapping(value = "/isExists", method = RequestMethod.POST)
    Response<List<UserInfoDTO>> isExists(@RequestParam("phones") String[] phones);

    /**
     * 查询站内信列表
     */
    @RequestMapping(value = "/queryStationLetter", method = RequestMethod.POST)
    Response<List<StationLetter>> queryStationLetter(@RequestBody ManageRequest request);

    /**
     * 批量获取用户信息
     */
    @RequestMapping(value = "/address/{addressId}", method = RequestMethod.POST)
    Response<Address> address(@PathVariable("addressId") Long addressId);
}
