package quick.pager.shop.auth.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.manage.Permission;
import quick.pager.shop.model.manage.RolePermission;

public interface RolePermissionMapper {

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermission record);

    /**
     * 查看某个角色具有的权限
     *
     * @param roleId 角色ID
     */
    List<RolePermission> selectPermissions(@Param("roleId") Long roleId);
}