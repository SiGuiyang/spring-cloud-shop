package quick.pager.shop.controller.customer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.user.response.Response;

/**
 * 管理平台用户服务
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class UserManageController {

    /**
     * 会员列表
     */
    @PostMapping("/member/list")
    public Response memberList() {
        return null;
    }
}
