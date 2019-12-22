package quick.pager.shop.manage.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.manage.mapper.MenuMapper;
import quick.pager.shop.manage.model.Menu;
import quick.pager.shop.manage.response.system.MenuResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.manage.param.LoginDTO;
import quick.pager.shop.manage.mapper.SysUserMapper;
import quick.pager.shop.manage.response.SysUserResponse;
import quick.pager.shop.manage.model.SysUser;
import quick.pager.shop.manage.utils.PrincipalUtils;
import quick.pager.shop.utils.BeanCopier;

/**
 * 用户信息| 包含权限
 *
 * @author siguiyang
 * @version 3.0
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
        SysUser queryUser = new SysUser();
        queryUser.setPhone(loginDTO.getUsername());
        queryUser.setDeleteStatus(Boolean.FALSE);
        SysUser sysUser = sysUserMapper.selectOne(new QueryWrapper<>(queryUser));

        if (Objects.isNull(sysUser)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_PHONE_NOT_EXISTS);
        }

        SysUserResponse sysUserResponse = new SysUserResponse();

        // 登陆用户所有角色
        Collection<? extends GrantedAuthority> authorities = PrincipalUtils.getPrincipal().getAuthorities();

        Set<String> permissions = Sets.newHashSet();
        authorities.forEach(auth -> permissions.add(auth.getAuthority()));

        // 所有访问菜单的路由
        List<Menu> menus = menuMapper.selectMenuBySysUserId(sysUser.getId());
        // 父级菜单
        List<MenuResponse> topMenu = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream()
                .filter(menu -> Objects.isNull(menu.getParentId()))
                .map(this::conv)
                .collect(Collectors.toList());
        // 这种写法是查出所有的菜单，移除顶级菜单，剩余的菜单就不是顶级菜单也就是parentId 都是不为null
        Map<Long, List<MenuResponse>> childrenMap = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream()
                .filter(item -> Objects.nonNull(item.getParentId()))
                .map(this::conv)
                .collect(Collectors.groupingBy(MenuResponse::getParentId, Collectors.toList()));
        // 整合成父子结构
        recursivePermission(topMenu, childrenMap, permissions);

        sysUserResponse.setPhone(sysUser.getPhone());
        sysUserResponse.setUsername(sysUser.getUsername());
        sysUserResponse.setRouters(topMenu);
        sysUserResponse.setPermissions(permissions);

        response.setData(sysUserResponse);

        return response;
    }

    /**
     * 获取访问菜单
     *
     * @param menus       TOP菜单
     * @param childrenMap 孩子节点菜单
     * @param permissions 权限
     */
    private void recursivePermission(List<MenuResponse> menus, Map<Long, List<MenuResponse>> childrenMap, Set<String> permissions) {
        menus.forEach(k -> {
            MenuResponse.Meta meta = new MenuResponse.Meta(k.getName(), k.getIcon(), k.getHidden(), permissions);
            k.setMeta(meta);
            List<MenuResponse> menuList = Optional.ofNullable(childrenMap.get(k.getId())).orElse(Collections.emptyList()).stream()
                    .filter(item -> 1 == item.getMenuType() && 1 == item.getMenuType())
                    .collect(Collectors.toList());
            recursivePermission(menuList, childrenMap, permissions);
            k.setChildren(menuList);
        });
    }

    private MenuResponse conv(Menu menu) {
        MenuResponse resp = new MenuResponse();
        BeanCopier.create(menu, resp).copy();
        resp.setLabel(menu.getName());
        if (Objects.isNull(menu.getParentId())) {
            resp.setComponent("Layout");
        }
        return resp;
    }
}
