package quick.pager.shop.user.controller.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.response.Response;

/**
 * 用户信息
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.USER)
public class AppUserProfileController {


    /**
     * 用户信息详情
     *
     * @param userId 用户主键
     * @return
     */
    @GetMapping("/app/{userId}/profile")
    public Response profile(@PathVariable("userId") Long userId) {
        return null;
    }
}
