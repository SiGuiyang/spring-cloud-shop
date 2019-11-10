package quick.pager.shop.controller.system;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.BindingResultUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.RoleDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.system.RoleService;

/**
 * 角色管理
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取系统角色
     */
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @PostMapping("/role/list")
    public Response systemRole(@RequestBody RoleDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return roleService.doService(dto);
    }

    /**
     * 新增系统角色
     */
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @PostMapping("/role")
    public Response addSystemRole(@Valid @RequestBody RoleDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        dto.setEvent(Constants.Event.ADD);
        return roleService.doService(dto);
    }

    /**
     * 修改系统角色
     */
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @PutMapping("/role")
    public Response modifySystemRole(@Valid @RequestBody RoleDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        dto.setEvent(Constants.Event.MODIFY);
        return roleService.doService(dto);
    }

    /**
     * 角色分类
     */
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @PostMapping("/role/classification")
    public Response roleClassification() {
        RoleDTO dto = new RoleDTO();
        dto.setEvent("classification");
        return roleService.doService(dto);
    }

    /**
     * 查看某个系统角色的权限列表
     */
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @PostMapping("/role/menu/{roleId}")
    public Response querySysUserPermission(@PathVariable("roleId") Long roleId) {
        RoleDTO dto = new RoleDTO();
        dto.setId(roleId);
        dto.setEvent("rolePermission");
        return roleService.doService(dto);
    }
}
