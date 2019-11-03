package quick.pager.shop.service.system;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.model.Menu;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.LoginDTO;
import quick.pager.shop.mapper.SysUserMapper;
import quick.pager.shop.response.SysUserResponse;
import quick.pager.shop.model.SysUser;
import quick.pager.shop.utils.PrincipalUtils;

/**
 * 用户信息| 包含权限
 */
@Service
@Slf4j
public class SysUserInfoService implements IService<SysUserResponse> {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Response<SysUserResponse> doService(BaseDTO dto) {

        LoginDTO loginDTO = (LoginDTO) dto;

        Response<SysUserResponse> response = new Response<>();

        SysUser sysUser = sysUserMapper.selectSysUserByUsername(loginDTO.getUsername());

        if (ObjectUtils.isEmpty(sysUser)) {
            response.setCode(ResponseStatus.Code.FAIL_CODE);
            response.setMsg(ResponseStatus.USER_PHONE_NOT_EXISTS);
            return response;
        }

        SysUserResponse sysUserResponse = new SysUserResponse();

        // 登陆用户所有角色
        Collection<? extends GrantedAuthority> authorities = PrincipalUtils.getPrincipal().getAuthorities();

        Set<String> permissions = Sets.newHashSet();
        authorities.forEach(auth -> permissions.add(auth.getAuthority()));

        // 所有访问菜单的路由
        List<Menu> menus = menuMapper.selectMenuBySysUserId(sysUser.getId());
        // 父级菜单
        List<Menu> topMenu = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream().filter(menu -> null == menu.getParentId()).collect(Collectors.toList());
        // 这种写法是查出所有的菜单，移除顶级菜单，剩余的菜单就不是顶级菜单也就是parentId 都是不为null
        Optional.ofNullable(menus).orElse(Collections.emptyList()).removeAll(topMenu);
        // 整合成父子结构
        List<Menu> routers = recursivePermission(Lists.newArrayList(), topMenu, menus, permissions);

        sysUserResponse.setPhone(sysUser.getPhone());
        sysUserResponse.setUsername(sysUser.getUsername());
        sysUserResponse.setRouters(routers);
        sysUserResponse.setPermissions(permissions);

        response.setData(sysUserResponse);

        return response;
    }

    /**
     * 获取访问菜单
     *
     * @param result      菜单
     * @param menus       菜单
     * @param permissions 权限
     */
    private List<Menu> recursivePermission(List<Menu> result, List<Menu> menus, List<Menu> menuList, Set<String> permissions) {

        menus.forEach(k -> {
            Menu.Meta meta = new Menu.Meta(k.getName(), k.getIcon(), k.getHidden(), permissions);
            k.setMeta(meta);
            // 顶级菜单的 component 元素值设置为Layout
            if (null == k.getParentId()) {
                k.setComponent("Layout");
            }
            // 筛选出此用户所拥有的菜单的子菜单
            List<Menu> child = menuList.stream().filter(s -> k.getId().compareTo(s.getParentId()) == 0 && 1 == k.getMenuType() && 1 == s.getMenuType()).collect(Collectors.toList());
            List<Menu> list = recursivePermission(Lists.newArrayList(), child, menuList, permissions);
            k.setChildren(list);
            result.add(k);
        });
        return result;
    }
}
