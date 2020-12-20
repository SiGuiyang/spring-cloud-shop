package quick.pager.shop.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
import quick.pager.shop.helper.MenuHelper;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.mapper.RoleMapper;
import quick.pager.shop.param.system.RoleOtherParam;
import quick.pager.shop.param.system.RolePageParam;
import quick.pager.shop.param.system.RoleSaveParam;
import quick.pager.shop.response.PermissionResponse;
import quick.pager.shop.response.system.MenuResponse;
import quick.pager.shop.response.system.RoleResponse;
import quick.pager.shop.service.system.RoleService;
import quick.pager.shop.model.Menu;
import quick.pager.shop.model.Role;
import quick.pager.shop.user.response.Response;
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
    @Autowired
    private MenuHelper menuHelper;

    @Override
    public Response<List<RoleResponse>> queryPage(final RolePageParam param) {
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<Role>()
                .eq(Role::getDeleteStatus, Boolean.FALSE)
                .likeRight(StringUtils.isNotBlank(param.getRoleName()), Role::getRoleName, param.getRoleName());

        Response<List<Role>> response = this.toPage(param.getPage(), param.getPageSize(), wrapper);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(item -> BeanCopier.create(item, new RoleResponse()).copy()).collect(Collectors.toList())
                , response.getTotal());
    }

    @Override
    public Response<List<RoleResponse>> queryList(final RoleOtherParam param) {

        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<Role>()
                .eq(Role::getDeleteStatus, Boolean.FALSE)
                .likeRight(StringUtils.isNotBlank(param.getRoleName()), Role::getRoleName, param.getRoleName());

        List<Role> roles = this.list(wrapper);

        return Response.toResponse(roles.stream().map(item -> BeanCopier.create(item, new RoleResponse()).copy()).collect(Collectors.toList()));
    }

    @Override
    public Response<Long> create(final RoleSaveParam param) {
        Role role = new Role();
        BeanCopier.create(param, role).copy();
        role.setDeleteStatus(Boolean.FALSE);
        role.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(role);
        return Response.toResponse(role.getId());
    }

    @Override
    public Response<Long> modify(final RoleSaveParam param) {
        Role role = new Role();
        BeanCopier.create(param, role).copy();
        this.baseMapper.updateById(role);
        return Response.toResponse(role.getId());
    }

    @Override
    public Response<Long> delete(final Long id) {
        this.baseMapper.deleteById(id);
        return Response.toResponse(id);
    }

    @Override
    public Response<PermissionResponse> queryRolePermission(final Long roleId) {

        List<Menu> menus = menuMapper.selectList(new LambdaQueryWrapper<Menu>().eq(Menu::getDeleteStatus, Boolean.FALSE));
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
        List<Menu> allMenus = menuHelper.selectMenuByRoleId(roleId);
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

        return Response.toResponse(response);
    }

    /**
     * 树形结构转换
     *
     * @param parentResp  顶级菜单
     * @param childrenMap 孩子节点
     * @param parentId    记录所有具有孩子节点的Id
     */
    private void toTree(final List<MenuResponse> parentResp, final Map<Long, List<MenuResponse>> childrenMap, final List<Long> parentId) {
        parentResp.forEach(item -> {
            List<MenuResponse> list = childrenMap.get(item.getId());
            toTree(Optional.ofNullable(list).orElse(Collections.emptyList()), childrenMap, parentId);
            item.setChildren(list);
            if (!CollectionUtils.isEmpty(item.getChildren())) {
                parentId.add(item.getId());
            }
        });
    }

    private MenuResponse conv(final Menu menu) {
        MenuResponse resp = new MenuResponse();
        BeanCopier.create(menu, resp).copy();
        resp.setMeta(new MenuResponse.Meta(menu.getName(), menu.getIcon(), false, null));
        if (Objects.isNull(resp.getParentId())) {
            resp.setComponent("Layout");
        }
        return resp;
    }
}
