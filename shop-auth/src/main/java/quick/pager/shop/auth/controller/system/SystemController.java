package quick.pager.shop.auth.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.shop.auth.dto.RoleDTO;
import quick.pager.shop.auth.service.system.RoleService;
import quick.pager.shop.auth.dto.AuthorizationDTO;
import quick.pager.shop.auth.dto.LoginDTO;
import quick.pager.shop.auth.dto.SysUserDTO;
import quick.pager.shop.auth.dto.SystemConfigDTO;
import quick.pager.shop.auth.service.system.LoginService;
import quick.pager.shop.auth.service.system.MenuService;
import quick.pager.shop.auth.service.system.PermissionService;
import quick.pager.shop.auth.service.system.SysUserInfoService;
import quick.pager.shop.auth.service.system.SysUserService;
import quick.pager.shop.auth.service.system.SystemConfigService;

/**
 * 系统管理
 *
 * @author siguiyang
 */
@Api(description = "系统管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class SystemController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private SysUserInfoService sysUserInfoService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SystemConfigService systemConfigService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private PermissionService permissionService;

    @ApiOperation("登陆")
    @PostMapping("/login")
    public Response login(@RequestParam String username, @RequestParam String password) {

        LoginDTO dto = new LoginDTO();
        dto.setUsername(username);
        dto.setPassword(password);

        return loginService.doService(dto);
    }

    @ApiOperation("系统登陆用户吧信息")
    @PostMapping("/system/adminInfo")
    public Response sysUserInfo(@RequestParam String sysCode) {
        LoginDTO dto = new LoginDTO();
        dto.setUsername(sysCode);

        return sysUserInfoService.doService(dto);
    }

    /**
     * 退出
     */
    @PostMapping("/logout")
    public Response logout() {
        return null;
    }


    @ApiOperation("系统用户列表")
    @PostMapping("/system/user")
    public Response systemUser(SysUserDTO dto) {
        dto.setEvent(Constants.Event.LIST);

        return sysUserService.doService(dto);
    }

    @ApiOperation("修改系统用户")
    @PostMapping("system/user/modify")
    public Response modifySystemUser(SysUserDTO dto) {

        return sysUserService.doService(dto);
    }

    @ApiOperation("系统权限列表")
    @PostMapping("/system/menu")
    public Response systemMenuList() {
        return menuService.doService(null);
    }

    @ApiOperation("查看某个系统角色的权限列表")
    @PostMapping("/system/menu/role")
    public Response querySysUserPermission(@RequestParam Long roleId) {
        RoleDTO dto = new RoleDTO();
        dto.setId(roleId);
        dto.setEvent("rolePermission");
        return roleService.doService(dto);
    }

    @ApiOperation("获取系统角色")
    @PostMapping("/system/role")
    public Response systemRole(RoleDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return roleService.doService(dto);
    }

    @ApiOperation("修改系统角色")
    @PostMapping("/system/role/modify")
    public Response modifySystemRole(RoleDTO dto) {
        return roleService.doService(dto);
    }

    @ApiOperation("角色分类")
    @PostMapping("/system/role/classification")
    public Response roleClassification() {
        RoleDTO dto = new RoleDTO();
        dto.setEvent("classification");
        return roleService.doService(dto);
    }

    @ApiOperation("菜单授权")
    @PostMapping("/system/permission")
    public Response permission(String permissions, Long roleId) {

        if (StringUtils.isEmpty(permissions)) {
            return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        AuthorizationDTO dto = new AuthorizationDTO();
        dto.setId(roleId);
        dto.setPermissions(permissions);

        return permissionService.doService(dto);
    }

    @ApiOperation("系统配置列表")
    @PostMapping("/system/config")
    public Response systemUser(SystemConfigDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return systemConfigService.doService(dto);
    }

    @ApiOperation("修改系统配置")
    @PostMapping("system/config/modify")
    public Response modifySystemUser(SystemConfigDTO dto) {
        return systemConfigService.doService(dto);
    }
}
