package quick.pager.shop.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.BindingResultUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.LoginDTO;
import quick.pager.shop.dto.SysUserDTO;
import quick.pager.shop.service.system.SysUserInfoService;
import quick.pager.shop.service.system.SysUserService;
import quick.pager.shop.utils.PrincipalUtils;

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
    private SysUserInfoService sysUserInfoService;
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("系统登陆用户吧信息")
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

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @ApiOperation("系统用户列表")
    @PostMapping("/system/user")
    public Response systemUser(SysUserDTO dto) {
        dto.setEvent(Constants.Event.LIST);

        return sysUserService.doService(dto);
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @ApiOperation("修改系统用户")
    @PostMapping("system/user/modify")
    public Response modifySystemUser(@Valid SysUserDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);

        return sysUserService.doService(dto);
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @ApiOperation("删除系统用户")
    @DeleteMapping("system/user/{id}")
    public Response delSystemUser(@PathVariable Long id) {
        SysUserDTO dto = new SysUserDTO();
        dto.setId(id);
        dto.setEvent(Constants.Event.DELETE);
        return sysUserService.doService(dto);
    }
}
