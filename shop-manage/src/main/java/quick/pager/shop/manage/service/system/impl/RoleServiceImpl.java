package quick.pager.shop.manage.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.manage.mapper.MenuMapper;
import quick.pager.shop.manage.mapper.RoleMapper;
import quick.pager.shop.manage.param.system.RoleOtherParam;
import quick.pager.shop.manage.param.system.RolePageParam;
import quick.pager.shop.manage.param.system.RoleSaveParam;
import quick.pager.shop.manage.response.PermissionResponse;
import quick.pager.shop.manage.response.system.MenuResponse;
import quick.pager.shop.manage.response.system.RoleResponse;
import quick.pager.shop.manage.service.system.RoleService;
import quick.pager.shop.manage.model.Menu;
import quick.pager.shop.manage.model.Role;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * 角色
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Response<List<RoleResponse>> queryPage(RolePageParam param) {
        Role role = new Role();
        role.setDeleteStatus(param.getDeleteStatus());
        if (StringUtils.isNotBlank(param.getRoleName())) {

            role.setRoleName(param.getRoleName());
        }
        QueryWrapper<Role> qw = new QueryWrapper<>(role);

        Response<List<Role>> response = this.toPage(param.getPage(), param.getPageSize(), qw);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(item -> BeanCopier.create(item, new RoleResponse()).copy()).collect(Collectors.toList())
                , response.getTotal());
    }

    @Override
    public Response<List<RoleResponse>> queryList(RoleOtherParam param) {

        Role role = new Role();
        role.setDeleteStatus(Boolean.FALSE);

        if (StringUtils.isNotEmpty(param.getRoleName())) {
            role.setRoleName(param.getRoleName());
        }
        List<Role> roles = this.list(new QueryWrapper<>(role));

        return new Response<>(roles.stream().map(item -> BeanCopier.create(item, new RoleResponse()).copy()).collect(Collectors.toList()));
    }

    @Override
    public Response<Long> create(RoleSaveParam param) {
        Role role = new Role();
        BeanCopier.create(param, role).copy();
        role.setDeleteStatus(Boolean.FALSE);
        role.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(role);
        return new Response<>(role.getId());
    }

    @Override
    public Response<Long> modify(RoleSaveParam param) {
        Role role = new Role();
        BeanCopier.create(param, role).copy();
        this.baseMapper.updateById(role);
        return new Response<>(role.getId());
    }

    @Override
    public Response<Long> delete(Long id) {
        Role role = new Role();
        role.setId(id);
        role.setDeleteStatus(Boolean.TRUE);
        this.baseMapper.updateById(role);
        return new Response<>(id);
    }

    @Override
    public Response<PermissionResponse> queryRolePermission(Long roleId) {

        Menu menu = new Menu();
        menu.setDeleteStatus(Boolean.FALSE);
        List<Menu> menus = menuMapper.selectList(new QueryWrapper<>(menu));
        // 得到顶级菜单
        List<MenuResponse> parentResp = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream()
                .filter(item -> Objects.isNull(item.getParentId()))
                .map(this::conv)
                .collect(Collectors.toList());
        // 按照parentId分组，用于树形结构组装数据
        Map<Long, List<MenuResponse>> childrenMap = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream()
                .filter(item -> Objects.nonNull(item.getParentId()) && 1 == item.getMenuType())
                .map(this::conv)
                .collect(Collectors.groupingBy(MenuResponse::getParentId, Collectors.toList()));
        // 记录父级元素的Id
        List<Long> parentIds = Lists.newArrayList();
        // 组装数据
        toTree(parentResp, childrenMap, parentIds);
        // 所有用户访问菜单的路由
        List<Menu> allMenus = menuMapper.selectMenuByRoleId(roleId);
        List<Long> routerPermissions = Optional.ofNullable(allMenus).orElse(Collections.emptyList()).stream()
                .filter(item -> 1 == item.getMenuType())
                .map(Menu::getId).distinct().collect(Collectors.toList());

        List<Long> btnPermissions = Optional.ofNullable(allMenus).orElse(Collections.emptyList()).stream()
                .filter(item -> 2 == item.getMenuType())
                .map(Menu::getId).distinct().collect(Collectors.toList());

        PermissionResponse response = new PermissionResponse();
        response.setRouterPermission(routerPermissions);
        response.setBtnPermission(btnPermissions);
        response.setRouters(parentResp);

        return new Response<>(response);
    }

    /**
     * 树形结构转换
     *
     * @param parentResp  顶级菜单
     * @param childrenMap 孩子节点
     * @param parentId    记录所有具有孩子节点的Id
     */
    private void toTree(List<MenuResponse> parentResp, Map<Long, List<MenuResponse>> childrenMap, List<Long> parentId) {
        parentResp.forEach(item -> {
            List<MenuResponse> list = childrenMap.get(item.getId());
            toTree(Optional.ofNullable(list).orElse(Collections.emptyList()), childrenMap, parentId);
            item.setChildren(list);
            if (!CollectionUtils.isEmpty(item.getChildren())) {
                parentId.add(item.getId());
            }
        });
    }

    private MenuResponse conv(Menu menu) {
        MenuResponse resp = new MenuResponse();
        BeanCopier.create(menu, resp).copy();
        resp.setMeta(new MenuResponse.Meta(menu.getName(), menu.getIcon(), false, null));
        if (Objects.isNull(resp.getParentId())) {
            resp.setComponent("Layout");
        }
        return resp;
    }
}
