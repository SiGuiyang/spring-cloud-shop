package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.Menu;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询最顶级的菜单
     */
    List<Menu> selectTopMenu();

    /**
     * 查询子菜单
     *
     * @param parentId 父级菜单
     * @param menuType 菜单类型
     */
    List<Menu> selectSubMenu(@Param("parentId") Long parentId, @Param("menuType") Integer menuType);

    /**
     * 查询指定的人所具有的菜单权限
     *
     * @param sysUserId 系统用户Id
     */
    List<Menu> selectMenuBySysUserId(@Param("sysUserId") Long sysUserId);

    /**
     * 查询角色具有的权限
     *
     * @param roleId 角色Id
     */
    List<Menu> selectMenuByRoleId(@Param("roleId") Long roleId);

    /**
     * 删除t_role_menu
     *
     * @param roleId 角色Id
     * @param menuId 菜单Id
     */
    int deleteRoleMenu(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    /**
     * 插入 t_role_menu
     *
     * @param roleId 角色Id
     * @param menuId 菜单Id
     */
    int insertRoleMenu(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

}
