package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.SysRole;

public interface SysRoleMapper {

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    /**
     * 根据roleId 与 sysUserId 查看系统用户角色
     *
     * @param roleId    t_role id
     * @param sysUserId t_sys_role id
     */
    SysRole selectSysRole(@Param("roleId") Long roleId, @Param("sysUserId") Long sysUserId);

    /**
     * 根据用户id查询角色
     */
    List<SysRole> selectBySysUserId( @Param("sysUserId") Long sysUserId);

}
