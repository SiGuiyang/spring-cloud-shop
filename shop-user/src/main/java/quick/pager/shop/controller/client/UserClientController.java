package quick.pager.shop.controller.client;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.model.StationLetter;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.request.ManageRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.UserInfoDTO;
import quick.pager.shop.model.Address;
import quick.pager.shop.service.client.UserClientService;

/**
 * feign 暴露的接口
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class UserClientController {

    @Autowired
    private UserClientService userClientService;

    /**
     * 获取用户信息
     *
     * @param userId 用户Id
     */
    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.POST)
    public Response<UserInfoDTO> getUser(@PathVariable("userId") Long userId) {
        List<UserInfoDTO> user = userClientService.getUser(Collections.singletonList(userId));
        if (CollectionUtils.isEmpty(user)) {
            return new Response<>();
        }
        return new Response<>(user.get(0));
    }

    /**
     * 批量获取用户信息
     *
     * @param userIds 用户Id集合
     */
    @RequestMapping(value = "/batchUser/profile", method = RequestMethod.POST)
    public Response<List<UserInfoDTO>> getBatchUser(@RequestParam("userIds") List<Long> userIds) {
        List<UserInfoDTO> user = userClientService.getUser(userIds);
        return new Response<>(user);
    }

    /**
     * 批量检测手机号是否存在
     *
     * @param phones 手机号集合
     */
    @RequestMapping(value = "/isExists", method = RequestMethod.POST)
    public Response isExists(@RequestParam("phones") List<String> phones) {
        if (CollectionUtils.isEmpty(phones)) {
            return new Response();
        }
        return userClientService.isExists(phones);
    }

    /**
     * 根据手机号查询用户信息
     *
     * @param phone 手机号
     */
    @RequestMapping(value = "/queryUser/profile", method = RequestMethod.POST)
    public Response<UserInfoDTO> queryUserProfile(@RequestParam("phone") String phone) {
        return userClientService.queryUserProfile(phone);
    }

    /**
     * 查询站内信列表
     */
    @RequestMapping(value = "/queryStationLetter", method = RequestMethod.POST)
    public Response<List<StationLetter>> queryStationLetter(@RequestBody ManageRequest request) {

        return userClientService.queryStationLetter(request.getPhone(), request.getPage(), request.getPageSize());
    }
}
