package quick.pager.shop.manage.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.manage.mapper.MenuMapper;
import quick.pager.shop.manage.model.Menu;
import quick.pager.shop.manage.response.system.MenuResponse;
import quick.pager.shop.manage.service.system.PermissionService;
import quick.pager.shop.properties.QiniuProperties;
import quick.pager.shop.response.Response;

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

    @Override
    public Response grant(List<Long> permissionIds, Long roleId) {
        // 此角色历史权限
        List<Menu> menus = menuMapper.selectMenuByRoleId(roleId);
        List<Long> menuIds = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream()
                .map(Menu::getId)
                .collect(Collectors.toList());
        // 剩余下值是取消的权限
        menuIds.stream()
                .filter(id -> !permissionIds.contains(id))
                .forEach(id -> menuMapper.deleteRoleMenu(roleId, id));
        // 剩下的值是新增的权限
        permissionIds.stream()
                .filter(id -> !menuIds.contains(id))
                .forEach(id -> menuMapper.insertRoleMenu(roleId, id));
        return new Response();
    }

    @Override
    public Response<List<MenuResponse>> permission(Long id) {

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

    private MenuResponse convert(Menu menu) {
        MenuResponse resp = new MenuResponse();
        resp.setId(menu.getId());
        resp.setName(menu.getName());
        return resp;
    }
}
