package quick.pager.shop.controller;

import io.swagger.annotations.ApiOperation;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.LoginDTO;
import quick.pager.shop.model.SysUser;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.system.LoginService;
import quick.pager.shop.service.system.SysUserClientService;

/**
 * 非需权限接口
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private SysUserClientService sysUserClientService;

    @ApiOperation("登陆")
    @PostMapping("/permit/login")
    public Response login(@RequestParam String username, @RequestParam String password) {

        LoginDTO dto = new LoginDTO();
        dto.setUsername(username);
        dto.setPassword(password);

        return loginService.doService(dto);
    }

    @ApiOperation("获取系统用户")
    @PostMapping("/permit/sysUser")
    public Response<SysUser> getSysUser(@RequestParam("username") String username) {
        return sysUserClientService.querySysUserByUsername(username);
    }

    @PostMapping("/permit/permission/{sysUserId}")
    public Response<Set<String>> getRolesBySysUserId(@PathVariable("sysUserId") Long sysUserId) {
        return sysUserClientService.getRolesBySysUserId(sysUserId);
    }

}
