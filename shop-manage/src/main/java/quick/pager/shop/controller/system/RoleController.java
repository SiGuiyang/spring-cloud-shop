package quick.pager.shop.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.RoleDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.system.RoleService;

@Api(description = "角色管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @ApiOperation("获取系统角色")
    @PostMapping("/role/list")
    public Response systemRole(RoleDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return roleService.doService(dto);
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @ApiOperation("新增系统角色")
    @PostMapping("/role")
    public Response addSystemRole(RoleDTO dto) {
        dto.setEvent(Constants.Event.ADD);
        return roleService.doService(dto);
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @ApiOperation("修改系统角色")
    @PutMapping("/role")
    public Response modifySystemRole(RoleDTO dto) {
        dto.setEvent(Constants.Event.MODIFY);
        return roleService.doService(dto);
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @ApiOperation("角色分类")
    @PostMapping("/role/classification")
    public Response roleClassification() {
        RoleDTO dto = new RoleDTO();
        dto.setEvent("classification");
        return roleService.doService(dto);
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @ApiOperation("查看某个系统角色的权限列表")
    @PostMapping("/role/menu/{roleId}")
    public Response querySysUserPermission(@PathVariable("roleId") Long roleId) {
        RoleDTO dto = new RoleDTO();
        dto.setId(roleId);
        dto.setEvent("rolePermission");
        return roleService.doService(dto);
    }
}
