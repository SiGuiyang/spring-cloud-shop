package quick.pager.shop.manage.controller.customer;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;

/**
 * 管理平台用户服务
 *
 * @author siguiyang
 */
@Api(description = "管理平台用户服务")
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
