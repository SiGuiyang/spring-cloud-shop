package quick.pager.shop.manage.service.system.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.manage.mapper.MenuMapper;
import quick.pager.shop.manage.model.Menu;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.manage.param.system.AuthorizationParam;

/**
 * 权限
 *
 * @author siguiyang
 * @version 3.0
 */
@Service
public class PermissionService implements IService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Response doService(BaseDTO dto) {

        AuthorizationParam authorizationParam = (AuthorizationParam) dto;

        // 此角色历史权限
        List<Menu> menus = menuMapper.selectMenuByRoleId(authorizationParam.getRoleId());
        List<Long> menuIds = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream()
                .map(Menu::getId)
                .collect(Collectors.toList());
        // 最新选择要授权的权限
        List<Long> permissionIds = authorizationParam.getPermissions();
        // 剩余下值是取消的权限
        menuIds.stream()
                .filter(id -> !permissionIds.contains(id))
                .forEach(id -> menuMapper.deleteRoleMenu(authorizationParam.getRoleId(), id));
        // 剩下的值是新增的权限
        permissionIds.stream()
                .filter(id -> !menuIds.contains(id))
                .forEach(id -> menuMapper.insertRoleMenu(authorizationParam.getRoleId(), id));

        return new Response();
    }
}
