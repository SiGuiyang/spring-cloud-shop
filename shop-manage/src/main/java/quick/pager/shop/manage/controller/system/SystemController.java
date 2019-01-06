package quick.pager.shop.manage.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.dto.LoginDTO;
import quick.pager.shop.manage.dto.RoleDTO;
import quick.pager.shop.manage.dto.SysUserDTO;
import quick.pager.shop.manage.dto.SystemConfigDTO;
import quick.pager.shop.manage.request.ConfigRequest;
import quick.pager.shop.manage.request.RoleRequest;
import quick.pager.shop.manage.request.SysUserRequest;
import quick.pager.shop.manage.service.system.LoginService;
import quick.pager.shop.manage.service.system.MenuService;
import quick.pager.shop.manage.service.system.RoleService;
import quick.pager.shop.manage.service.system.SysUserInfoService;
import quick.pager.shop.manage.service.system.SysUserService;
import quick.pager.shop.manage.service.system.SystemConfigService;

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

    @ApiOperation("登陆")
    @PostMapping("/login")
    public Response login(@RequestParam String username, @RequestParam String password) {

        LoginDTO dto = new LoginDTO();
        dto.setUsername(username);
        dto.setPassword(password);

        return loginService.doService(dto);
    }

    @ApiOperation("系统登陆用户吧信息")
    @PostMapping("/system/userInfo")
    public Response sysUserInfo(@RequestParam String sysCode) {
        LoginDTO dto = new LoginDTO();
        dto.setUsername(sysCode);

        return sysUserInfoService.doService(dto);
    }


    /**
     * 退出
     */
    @PostMapping("/admin/logout")
    public Response logout() {
        return null;
    }


    @ApiOperation("系统用户列表")
    @PostMapping("/system/user")
    public Response systemUser(SysUserRequest request) {
        SysUserDTO dto = new SysUserDTO();
        dto.setSysName(request.getSysName());
        dto.setCreateUser(request.getCreateUser());
        dto.setPage(request.getPage());
        dto.setPageSize(request.getPageSize());
        dto.setEvent(Constants.Event.LIST);

        return sysUserService.doService(dto);
    }

    @ApiOperation("修改系统用户")
    @PostMapping("system/user/modify")
    public Response modifySystemUser(SysUserRequest request) {
        SysUserDTO dto = new SysUserDTO();
        dto.setId(request.getId());
        dto.setSysName(request.getSysName());
        dto.setAvatar(request.getAvatar());
        dto.setPassword(request.getPassword());
        dto.setRoleCode(request.getRoleCode());
        dto.setCreateUser(request.getCreateUser());
        dto.setPage(request.getPage());
        dto.setPageSize(request.getPageSize());
        dto.setEvent(request.getEvent());

        return sysUserService.doService(dto);
    }

    @ApiOperation("系统权限列表")
    @PostMapping("/system/menu")
    public Response systemMenuList() {
        return menuService.doService(null);
    }

    @ApiOperation("查看某个系统用户的权限列表")
    @PostMapping("/system/menu/{sysId}")
    public Response querySysUserPermission(@PathVariable("sysId") Long sysId) {
        return null;
    }

    @ApiOperation("获取系统角色")
    @PostMapping("/system/role")
    public Response systemRole(RoleRequest request) {
        RoleDTO dto = new RoleDTO();
        dto.setRoleName(request.getRoleName());
        dto.setEvent(Constants.Event.LIST);
        dto.setPage(request.getPage());
        dto.setPageSize(request.getPageSize());
        return roleService.doService(dto);
    }

    @ApiOperation("修改系统角色")
    @PostMapping("/system/role/modify")
    public Response modifySystemRole(RoleRequest request) {
        RoleDTO dto = new RoleDTO();
        dto.setRoleName(request.getRoleName());
        dto.setRoleCode(request.getRoleCode());
        dto.setCreateUser(request.getCreateUser());
        dto.setDeleteStatus(request.getDeleteStatus());
        dto.setEvent(request.getEvent());
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
    public Response permission() {
        return null;
    }

    @ApiOperation("系统配置列表")
    @PostMapping("/system/config")
    public Response systemUser(ConfigRequest request) {
        SystemConfigDTO dto = new SystemConfigDTO();
        dto.setConfigName(request.getConfigName());
        dto.setModule(request.getModule());
        dto.setPage(request.getPage());
        dto.setPageSize(request.getPageSize());
        dto.setEvent(Constants.Event.LIST);
        return systemConfigService.doService(dto);
    }

    @ApiOperation("修改系统配置")
    @PostMapping("system/config/modify")
    public Response modifySystemUser(ConfigRequest request) {
        SystemConfigDTO dto = new SystemConfigDTO();
        dto.setConfigName(request.getConfigName());
        dto.setConfigValue(request.getConfigValue());
        dto.setModule(request.getModule());
        dto.setDescription(request.getDescription());
        dto.setDeleteStatus(request.getDeleteStatus());
        dto.setId(request.getId());
        dto.setEvent(request.getEvent());
        dto.setPage(request.getPage());
        dto.setPageSize(request.getPageSize());
        return systemConfigService.doService(dto);
    }
}
