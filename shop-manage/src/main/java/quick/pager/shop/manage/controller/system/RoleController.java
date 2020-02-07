package quick.pager.shop.manage.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.manage.param.system.RoleOtherParam;
import quick.pager.shop.manage.param.system.RolePageParam;
import quick.pager.shop.manage.param.system.RoleSaveParam;
import quick.pager.shop.manage.response.PermissionResponse;
import quick.pager.shop.manage.service.system.RoleService;
import quick.pager.shop.response.Response;

/**
 * 角色管理
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取系统角色
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_ROLE')")
    @PostMapping("/role/list")
    public Response systemRole(@RequestBody RolePageParam param) {
        return roleService.queryPage(param);
    }

    /**
     * 新增系统角色
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_ROLE_CREATE')")
    @PostMapping("/role")
    public Response addSystemRole(@RequestBody RoleSaveParam dto) {
        return roleService.create(dto);
    }

    /**
     * 修改系统角色
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_ROLE_MODIFY')")
    @PutMapping("/role")
    public Response modifySystemRole(@RequestBody RoleSaveParam dto) {
        return roleService.modify(dto);
    }

    /**
     * 角色分类
     */
    @PostMapping("/role/classification")
    public Response roleClassification() {
        return roleService.queryList(new RoleOtherParam());
    }

    /**
     * 查看某个系统角色的权限列表
     */
    @PostMapping("/role/menu/{roleId}")
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_ROLE_PERMISSION')")
    public Response<PermissionResponse> querySysUserPermission(@PathVariable("roleId") Long roleId) {
        return roleService.queryRolePermission(roleId);
    }
}
