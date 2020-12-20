package quick.pager.shop.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.helper.MenuHelper;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.mapper.RoleMenuMapper;
import quick.pager.shop.model.Menu;
import quick.pager.shop.model.RoleMenu;
import quick.pager.shop.response.system.MenuResponse;
import quick.pager.shop.service.system.PermissionService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.DateUtils;

/**
 * 权限
 *
 * @author siguiyang
 * @version 3.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuHelper menuHelper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public Response grant(final List<Long> permission, final Long roleId) {
        // 此角色历史权限
        List<Menu> menus = menuHelper.selectMenuByRoleId(roleId);
        // 剩余下值是取消的权限
        menus.stream().filter(menu -> !permission.contains(menu.getId())).forEach(menu -> {
            LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(RoleMenu::getRoleId, roleId);
            wrapper.eq(RoleMenu::getPermission, menu.getPermission());
            // 删除角色权限
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setDeleteStatus(Boolean.TRUE);
            roleMenuMapper.update(roleMenu, wrapper);
        });

        // 剩下的值是新增的权限
        for (Long perm : permission) {
            for (Menu menu : menus) {
                if (menu.getId().compareTo(perm) != 0) {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setPermission(menu.getPermission());
                    roleMenu.setRoleId(roleId);
                    roleMenu.setCreateTime(DateUtils.dateTime());
                    roleMenu.setUpdateTime(DateUtils.dateTime());
                    roleMenu.setDeleteStatus(Boolean.FALSE);
                    roleMenuMapper.insert(roleMenu);
                    break;
                }
            }
        }
        return Response.toResponse();
    }

    @Override
    public Response<List<MenuResponse>> permission(final Long id) {

        Menu menu = new Menu();
        menu.setMenuType(2);
        menu.setParentId(id);
        menu.setDeleteStatus(Boolean.FALSE);

        QueryWrapper<Menu> qw = new QueryWrapper<>(menu);
        List<Menu> menuList = menuMapper.selectList(qw);

        return Response.toResponse(Optional.ofNullable(menuList).orElse(Collections.emptyList()).stream()
                        .map(this::convert).collect(Collectors.toList()),
                0);
    }

    private MenuResponse convert(final Menu menu) {
        MenuResponse resp = new MenuResponse();
        resp.setId(menu.getId());
        resp.setName(menu.getName());
        return resp;
    }
}
