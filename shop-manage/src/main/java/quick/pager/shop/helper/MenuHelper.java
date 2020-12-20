package quick.pager.shop.helper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.mapper.RoleMenuMapper;
import quick.pager.shop.mapper.SysRoleMapper;
import quick.pager.shop.model.Menu;
import quick.pager.shop.model.RoleMenu;
import quick.pager.shop.model.SysRole;

/**
 * 菜单工具类
 *
 * @author siguiyang
 */
@Component
public class MenuHelper {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据当前用户主键查询权限菜单
     *
     * @param sysUserId 用户主键
     * @return 菜单集
     */
    public List<Menu> selectMenuBySysUserId(final Long sysUserId) {
        LambdaQueryWrapper<SysRole> sysRoleWrapper = new LambdaQueryWrapper<>();
        sysRoleWrapper.eq(SysRole::getDeleteStatus, Boolean.FALSE);
        sysRoleWrapper.eq(SysRole::getSysUserId, sysUserId);
        List<SysRole> sysRoles = sysRoleMapper.selectList(sysRoleWrapper);
        List<Long> roleIds = sysRoles.stream()
                .map(SysRole::getRoleId)
                .distinct()
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(roleIds)) {
            return Collections.emptyList();
        }

        return selectMenuByRoleIds(roleIds);
    }

    /**
     * 通过角色查询当前角色所拥有的权限
     *
     * @param roleId 角色主键
     * @return 菜单集
     */
    public List<Menu> selectMenuByRoleId(final Long roleId) {
        return selectMenuByRoleIds(Collections.singletonList(roleId));
    }

    /**
     * 通过角色查询当前角色所拥有的权限
     *
     * @param roleIds 角色主键集
     * @return 菜单集
     */
    private List<Menu> selectMenuByRoleIds(final List<Long> roleIds) {
        // 角色所属权限编码
        LambdaQueryWrapper<RoleMenu> roleMenuWrapper = new LambdaQueryWrapper<>();
        roleMenuWrapper.eq(RoleMenu::getDeleteStatus, Boolean.FALSE);
        roleMenuWrapper.in(RoleMenu::getRoleId, roleIds);
        List<RoleMenu> roleMenus = roleMenuMapper.selectList(roleMenuWrapper);

        if (CollectionUtils.isEmpty(roleMenus)) {
            return Collections.emptyList();
        }

        List<String> permissions = roleMenus.stream()
                .filter(item -> !StringUtils.isEmpty(item.getPermission()))
                .map(RoleMenu::getPermission)
                .distinct()
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(permissions)) {
            return Collections.emptyList();
        }

        LambdaQueryWrapper<Menu> menuWrapper = new LambdaQueryWrapper<>();
        menuWrapper.eq(Menu::getDeleteStatus, Boolean.FALSE);
        menuWrapper.in(Menu::getPermission, permissions);
        menuWrapper.orderByAsc(Menu::getSequence);
        return menuMapper.selectList(menuWrapper);
    }
}
