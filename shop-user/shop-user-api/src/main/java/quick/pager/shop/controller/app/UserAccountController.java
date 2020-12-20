package quick.pager.shop.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.model.LoginUser;
import quick.pager.shop.service.UserAccountService;
import quick.pager.shop.service.UserService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserAccountResponse;
import quick.pager.shop.user.response.UserProfileResponse;
import quick.pager.shop.util.AuthUtils;

/**
 * 用户账户会员
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private UserService userService;

    /**
     * 根据用户主键查询用户账户信息
     *
     * @return 户账户信息
     */
    @PostMapping("/app/account/")
    public Response<UserAccountResponse> account() {
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return userAccountService.account(principal.getId());
    }

    /**
     * app 短信登录
     *
     * @param phone 短信登录手机号码
     */
    @PostMapping("/app/login/sms")
    public Response<UserProfileResponse> login(@RequestParam("phone") String phone) {
        return userService.login(phone);
    }
}
