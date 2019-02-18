package quick.pager.shop.auth.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.manage.Permission;

public interface PermissionMapper {

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    /**
     * 查询最顶级的菜单
     */
    List<Permission> selectTopMenu();

    /**
     * 查询子菜单
     *
     * @param parentId 父级菜单
     */
    List<Permission> selectSubMenu(@Param("parentId") Long parentId);

    /**
     * 系统登陆的用户所有权限
     *
     * @param sysUserId 系统登陆用户的Id
     */
    List<Permission> selectPermissions(@Param("sysUserId") Long sysUserId);

}