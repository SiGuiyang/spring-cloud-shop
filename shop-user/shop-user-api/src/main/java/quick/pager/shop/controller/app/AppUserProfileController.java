package quick.pager.shop.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.model.LoginUser;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserProfileResponse;
import quick.pager.shop.service.UserService;
import quick.pager.shop.util.AuthUtils;

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
     */
    @PostMapping("/app/profile")
    public Response<UserProfileResponse> profile() {
        // 获取当前登录人
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return userService.profile(principal.getId());
    }
}
