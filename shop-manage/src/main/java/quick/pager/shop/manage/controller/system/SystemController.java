package quick.pager.shop.manage.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.manage.param.system.SysUserPageParam;
import quick.pager.shop.manage.service.system.SysUserService;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.param.system.SysUserParam;
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
    private SysUserService sysUserService;

    /**
     * 系统登陆用户吧信息
     */
    @PostMapping("/system/adminInfo")
    public Response sysUserInfo() {
        return sysUserService.adminInfo(PrincipalUtils.getPrincipal().getName());
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
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_USER')")
    @PostMapping("/system/user/page")
    public Response queryPage(@RequestBody SysUserPageParam param) {
        return sysUserService.queryPage(param);
    }

    /**
     * 新增系统用户
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_USER_CREATE')")
    @PostMapping("system/user/create")
    public Response create(@RequestBody SysUserParam param) {

        return sysUserService.create(param);
    }

    /**
     * 修改系统用户
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_USER_MODIFY')")
    @PutMapping("system/user/modify")
    public Response modify(@RequestBody SysUserParam dto) {

        return sysUserService.modify(dto);
    }
}
