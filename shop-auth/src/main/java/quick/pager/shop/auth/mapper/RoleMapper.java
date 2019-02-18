package quick.pager.shop.auth.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.manage.Role;

public interface RoleMapper {
    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    /**
     * 获取所有的角色
     */
    List<Role> selectRoles(@Param("roleName") String roleName, @Param("deleteStatus") Boolean deleteStatus);

}