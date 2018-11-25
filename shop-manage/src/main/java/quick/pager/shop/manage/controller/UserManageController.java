package quick.pager.shop.manage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.response.Response;

/**
 * 管理平台用户服务
 *
 * @author siguiyang
 */
@RestController
public class UserManageController {

    /**
     * 登陆
     */
    @PostMapping("/admin/login")
    public Response login() {
        return null;
    }


    /**
     * 退出
     */
    @PostMapping("/admin/logout")
    public Response logout() {
        return null;
    }

    /**
     * 会员列表
     */
    @PostMapping("/admin/member/list")
    public Response memberList() {
        return null;
    }
}
