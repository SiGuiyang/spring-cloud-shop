package quick.pager.shop.manage.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.param.LoginDTO;
import quick.pager.shop.manage.param.system.SysUserParam;
import quick.pager.shop.manage.service.system.impl.SysUserInfoService;
import quick.pager.shop.manage.service.system.impl.SysUserService;
import quick.pager.shop.manage.utils.PrincipalUtils;

/**
 * 系统管理
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class SystemController {

    @Autowired
    private SysUserInfoService sysUserInfoService;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 系统登陆用户吧信息
     */
    @PostMapping("/system/adminInfo")
    public Response sysUserInfo() {
        LoginDTO dto = new LoginDTO();
        dto.setUsername(PrincipalUtils.getPrincipal().getName());

        return sysUserInfoService.doService(dto);
    }

    /**
     * 退出
     */
    @PostMapping("/logout")
    public Response logout() {
        return new Response();
    }

    /**
     * 系统用户列表
     */
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @PostMapping("/system/user")
    public Response systemUser(@RequestBody SysUserParam dto) {
        dto.setEvent(Constants.Event.LIST);

        return sysUserService.doService(dto);
    }

    /**
     * 修改系统用户
     */
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @PostMapping("system/user/modify")
    public Response modifySystemUser(@RequestBody SysUserParam dto) {

        return sysUserService.doService(dto);
    }

    /**
     * 修改状态系统用户
     */
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @PostMapping("system/user/{id}")
    public Response delSystemUser(@PathVariable Long id, @RequestBody SysUserParam dto) {
        SysUserParam sysUserParam = new SysUserParam();
        sysUserParam.setDeleteStatus(dto.getDeleteStatus());
        sysUserParam.setId(id);
        sysUserParam.setEvent("status");
        return sysUserService.doService(sysUserParam);
    }
}
