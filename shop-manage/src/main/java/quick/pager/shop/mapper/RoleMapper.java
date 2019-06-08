package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.Role;
@Mapper
public interface RoleMapper {
    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    /**
     * 根据系统用户ID查询角色
     */
    List<Role> selectRoleBySysUserId(@Param("sysUserId") Long sysUserId);

    /**
     * 获取所有的角色
     */
    List<Role> selectRoles(@Param("roleName") String roleName, @Param("deleteStatus") Boolean deleteStatus);

}
