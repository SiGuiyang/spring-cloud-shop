package quick.pager.shop.order.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.common.response.Response;
import quick.pager.shop.model.common.Address;
import quick.pager.shop.model.feign.dto.UserInfoDTO;

/**
 * 用户模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-user")
public interface UserClient {

    /**
     * 获取用户信息
     *
     * @param userId 用户Id
     */
    @RequestMapping(value = "/user/getUser/{userId}", method = RequestMethod.POST)
    Response<UserInfoDTO> getUser(@PathVariable("userId") Long userId);

    /**
     * 批量获取用户信息
     */
    @RequestMapping(value = "/user/batchUser/profile")
    Response<List<UserInfoDTO>> getBatchUser(@RequestParam("userIds") Long[] userIds);

    /**
     * 批量获取用户信息
     */
    @RequestMapping(value = "/user/queryAddress/{addressId}", method = RequestMethod.POST)
    Response<Address> queryAddress(@RequestParam("addressId") Long addressId);
}
