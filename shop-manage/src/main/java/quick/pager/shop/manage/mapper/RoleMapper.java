package quick.pager.shop.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.manage.model.Role;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据系统用户ID查询角色
     */
    List<Role> selectRoleBySysUserId(@Param("sysUserId") Long sysUserId);

    /**
     * 获取所有的角色
     */
    List<Role> selectRoles(@Param("roleName") String roleName, @Param("deleteStatus") Boolean deleteStatus);

}
