package quick.pager.shop.manage.controller.system;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.manage.param.system.AuthorizationParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.system.impl.PermissionService;

/**
 * 权限
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 菜单授权
     */
    @PostMapping("/permission")
    public Response permission(@RequestBody AuthorizationParam param) {

        if (Objects.isNull(param.getRoleId())) {
            return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return permissionService.doService(param);
    }
}
