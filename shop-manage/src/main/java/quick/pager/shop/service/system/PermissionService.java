package quick.pager.shop.service.system;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.model.Menu;
import quick.pager.shop.model.Model;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.AuthorizationDTO;

/**
 * 权限
 *
 * @author siguiyang
 */
@Service
public class PermissionService implements IService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Response doService(BaseDTO dto) {

        AuthorizationDTO authorizationDTO = (AuthorizationDTO) dto;

        // 此角色历史权限
        List<Menu> menus = menuMapper.selectMenuByRoleId(authorizationDTO.getId());
        List<Long> menuIds = Optional.of(menus).orElse(Collections.emptyList()).stream().map(Model::getId).collect(Collectors.toList());

        // 拷贝权限
        List<Long> copyHistoryPermissions = Lists.newArrayList(menuIds);

        // 最新选择要授权的权限
        List<Long> permissionIds = JSON.parseArray(authorizationDTO.getPermissions(), Long.class);

        // 剩余下值是取消的权限
        menuIds.removeAll(permissionIds);

        // 剩下的值是新增的权限
        permissionIds.removeAll(copyHistoryPermissions);


        // 删除取消的权限
        menuIds.forEach(p -> menuMapper.deleteRoleMenu(authorizationDTO.getId(), p));

        // 新增权限
        permissionIds.forEach(p -> menuMapper.insertRoleMenu(authorizationDTO.getId(), p));


        return new Response();
    }
}
