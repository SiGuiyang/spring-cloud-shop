package quick.pager.shop.user.controller.client;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.model.feign.dto.UserInfoDTO;
import quick.pager.shop.user.service.client.UserClientService;

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
    public Response isExists(@RequestParam List<String> phones) {
        if (CollectionUtils.isEmpty(phones)) {
            return new Response();
        }
        return userClientService.isExists(phones);
    }
}
