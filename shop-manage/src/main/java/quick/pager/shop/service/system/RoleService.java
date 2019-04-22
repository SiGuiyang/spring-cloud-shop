package quick.pager.shop.service.system;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.model.Menu;
import quick.pager.shop.response.PermissionResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.RoleDTO;
import quick.pager.shop.mapper.RoleMapper;
import quick.pager.shop.model.Role;

/**
 * 角色
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class RoleService implements IService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Response doService(BaseDTO dto) {
        RoleDTO roleDTO = (RoleDTO) dto;
        Response response;
        switch (roleDTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modifyRole(roleDTO);
                break;
            case Constants.Event.LIST:
                response = selectRoles(roleDTO);
                break;
            case Constants.Event.DELETE:
                response = delRole(roleDTO.getId());
                break;
            case "classification":
                response = getRoleClassification();
                break;
            case "rolePermission": // 查看某个角色的权限
                response = getRolePermission(roleDTO);
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return response;
    }

    private Response delRole(Long id) {
        Role role = new Role();
        role.setId(id);
        role.setDeleteStatus(true);
        roleMapper.updateByPrimaryKeySelective(role);
        return new Response();
    }

    /**
     * 查看某个角色的权限
     */
    private Response<PermissionResponse> getRolePermission(RoleDTO roleDTO) {

        // 记录父级元素的Id
        List<Long> parentIds = Lists.newArrayList();
        // 系统顶级菜单
        List<Menu> topMenu = menuMapper.selectTopMenu();
        // 系统所有菜单
        List<Menu> menus = recursivePermission(Lists.newArrayList(), parentIds, topMenu, null);

        // 所有用户访问菜单的路由
        List<Menu> allMenus = menuMapper.selectMenuByRoleId(roleDTO.getId());

        Set<Long> hadPermissionIds = Optional.ofNullable(allMenus).orElse(Collections.emptyList()).stream().map(Menu::getId).collect(Collectors.toSet());
        /*
         * 这种做法是帮助页面显示的<br />
         * 原因 v-tree 父节点只要被选中，则它的所有子节点会选中<br />
         * 这样不符合逻辑<br />
         */
        hadPermissionIds.removeAll(parentIds);
        PermissionResponse response = new PermissionResponse();
        response.setHadPermissions(hadPermissionIds);
        response.setMenus(menus);

        return new Response<>(response);
    }

    private List<Menu> recursivePermission(List<Menu> result, List<Long> parentIds, List<Menu> menus, Integer menuType) {

        menus.forEach(k -> {
            Menu.Meta meta = new Menu.Meta(k.getName(), k.getIcon(), false, null);
            k.setMeta(meta);
            // 顶级菜单的 component 元素值设置为Layout
            if (null == k.getParentId()) {
                k.setComponent("Layout");
            }
            List<Menu> list = recursivePermission(Lists.newArrayList(), parentIds, menuMapper.selectSubMenu(k.getId(), menuType), menuType);
            k.setChildren(list);
            if (k.getChildren().size() > 0) {
                parentIds.add(k.getId());
            }
            result.add(k);
        });
        return result;
    }

    // 角色分类
    private Response getRoleClassification() {
        List<Role> roles = roleMapper.selectRoles(null, Boolean.FALSE);
        Response<List<Role>> response = new Response<>();
        response.setData(roles);
        return response;
    }

    // 角色列表
    private Response selectRoles(RoleDTO roleDTO) {
        PageHelper.startPage(roleDTO.getPage(), roleDTO.getPageSize());
        List<Role> roles = roleMapper.selectRoles(roleDTO.getRoleName(), null);

        return Response.toResponse(roles);
    }

    // 新增修改角色
    private Response modifyRole(RoleDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        if (Constants.Event.ADD.equals(dto.getEvent())) { // 新增
            role.setDeleteStatus(false);
            role.setCreateTime(new Date());
            roleMapper.insertSelective(role);
        } else {
            roleMapper.updateByPrimaryKeySelective(role);
        }
        return new Response();
    }
}
