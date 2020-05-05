package quick.pager.shop.manage.controller.system;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
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
    @PostMapping("/role/page")
    public Response page(@RequestBody RolePageParam param) {
        return roleService.queryPage(param);
    }

    /**
     * 获取系统角色
     */
    @PostMapping("/role/list")
    public Response list(@RequestBody RoleOtherParam param) {
        return roleService.queryList(param);
    }


    /**
     * 新增系统角色
     */
    @PostMapping("/role/create")
    public Response create(@RequestBody RoleSaveParam param) {
        return roleService.create(param);
    }

    /**
     * 修改系统角色
     */
    @PutMapping("/role/modify")
    public Response<Long> modify(@RequestBody RoleSaveParam param) {
        if (Objects.isNull(param.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return roleService.modify(param);
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
    public Response<PermissionResponse> querySysUserPermission(@PathVariable("roleId") Long roleId) {
        return roleService.queryRolePermission(roleId);
    }
}
