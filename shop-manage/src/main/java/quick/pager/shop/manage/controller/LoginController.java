package quick.pager.shop.manage.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.manage.model.SysUser;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.system.impl.SysUserClientService;

/**
 * 非需权限接口
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class LoginController {

    @Autowired
    private SysUserClientService sysUserClientService;

    /**
     * 获取系统用户
     */
    @PostMapping("/permit/sysUser")
    public Response<SysUser> getSysUser(@RequestParam("phone") String phone) {
        return sysUserClientService.querySysUserByUsername(phone);
    }

    /**
     * 登陆获取用户的权限
     *
     * @param sysUserId 登陆的用户主键
     */
    @PostMapping("/permit/permission/{sysUserId}")
    public Response<List<String>> getRolesBySysUserId(@PathVariable("sysUserId") Long sysUserId) {
        return sysUserClientService.getRolesBySysUserId(sysUserId);
    }

}
