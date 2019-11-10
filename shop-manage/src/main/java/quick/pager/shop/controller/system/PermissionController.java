package quick.pager.shop.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.AuthorizationDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.system.PermissionService;

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
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @PostMapping("/permission")
    public Response permission(@RequestBody AuthorizationDTO dto) {

        return permissionService.doService(dto);
    }
}
