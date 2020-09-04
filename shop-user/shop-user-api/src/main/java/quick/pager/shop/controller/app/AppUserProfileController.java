package quick.pager.shop.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserProfileResponse;
import quick.pager.shop.service.UserService;

/**
 * 用户信息
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.USER)
public class AppUserProfileController {

    @Autowired
    private UserService userService;

    /**
     * 用户信息详情
     *
     * @param userId 用户主键
     */
    @GetMapping("/app/{userId}/profile")
    public Response<UserProfileResponse> profile(@PathVariable("userId") Long userId) {
        return userService.profile(userId);
    }
}
