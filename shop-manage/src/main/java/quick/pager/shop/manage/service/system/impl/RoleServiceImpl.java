package quick.pager.shop.manage.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.manage.mapper.MenuMapper;
import quick.pager.shop.manage.mapper.RoleMapper;
import quick.pager.shop.manage.param.system.RoleParam;
import quick.pager.shop.manage.response.PermissionResponse;
import quick.pager.shop.manage.response.system.MenuResponse;
import quick.pager.shop.manage.service.system.RoleService;
import quick.pager.shop.manage.model.Menu;
import quick.pager.shop.manage.model.Role;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * 角色
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Response<List<Role>> queryPage(RoleParam param) {
        Page<Role> page = new Page<>(param.getPage(), param.getPageSize());
        Role role = new Role();
        role.setRoleName(param.getRoleName());
        role.setDeleteStatus(param.getDeleteStatus());
        return Response.toResponse(roleMapper.selectPage(page, new QueryWrapper<>(role)));
    }

    @Override
    public Response<List<Role>> queryList(RoleParam param) {

        Role role = new Role();
        role.setDeleteStatus(Boolean.FALSE);

        if (StringUtils.isNotEmpty(param.getRoleName())) {
            role.setRoleName(param.getRoleName());
        }

        return new Response<>(roleMapper.selectList(new QueryWrapper<>(role)));
    }

    @Override
    public Response<Long> create(RoleParam param) {
        Role role = new Role();
        BeanCopier.create(param, role).copy();
        role.setDeleteStatus(Boolean.FALSE);
        role.setCreateTime(DateUtils.dateTime());
        roleMapper.insert(role);
        return new Response<>(role.getId());
    }

    @Override
    public Response<Long> modify(RoleParam param) {
        Role role = new Role();
        BeanCopier.create(param, role).copy();
        roleMapper.updateById(role);
        return new Response<>(role.getId());
    }

    @Override
    public Response<Long> delete(Long id) {
        Role role = new Role();
        role.setId(id);
        role.setDeleteStatus(Boolean.TRUE);
        roleMapper.updateById(role);
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
                .filter(item -> Objects.nonNull(item.getParentId()))
                .map(this::conv)
                .collect(Collectors.groupingBy(MenuResponse::getParentId, Collectors.toList()));
        // 记录父级元素的Id
        List<Long> parentIds = Lists.newArrayList();
        // 组装数据
        toTree(parentResp, childrenMap, parentIds);
        // 所有用户访问菜单的路由
        List<Menu> allMenus = menuMapper.selectMenuByRoleId(roleId);
        /*
         * 这种做法是帮助页面显示的<br />
         * 原因 v-tree 父节点只要被选中，则它的所有子节点会选中<br />
         * 这样不符合逻辑<br />
         */
        List<Long> menuIds = parentResp.stream().map(MenuResponse::getId).collect(Collectors.toList());
        Set<Long> hadPermissionIds = Optional.ofNullable(allMenus).orElse(Collections.emptyList()).stream()
                .filter(item -> !menuIds.contains(item.getId()))
                .filter(item -> !parentIds.contains(item.getId()))
                .map(Menu::getId).collect(Collectors.toSet());

        PermissionResponse response = new PermissionResponse();
        response.setHadPermissions(hadPermissionIds);
        response.setMenus(parentResp);

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
        resp.setId(menu.getId());
        resp.setParentId(menu.getParentId());
        resp.setName(menu.getName());
        resp.setComponent(menu.getComponent());
        resp.setMenuType(menu.getMenuType());
        resp.setSequence(menu.getSequence());
        resp.setPath(menu.getPath());
        resp.setRedirect(menu.getRedirect());
        resp.setHidden(menu.getHidden());
        resp.setIcon(menu.getIcon());
        resp.setMeta(new MenuResponse.Meta(menu.getName(), menu.getIcon(), false, null));
        if (Objects.isNull(resp.getParentId())) {
            resp.setComponent("Layout");
        }
        return resp;
    }
}
