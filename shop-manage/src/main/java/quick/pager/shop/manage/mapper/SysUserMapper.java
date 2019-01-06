package quick.pager.shop.manage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.manage.SysUser;

public interface SysUserMapper {

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 根据用户名查询系统登陆用户
     *
     * @param username
     * @return
     */
    SysUser selectSysUserBySysCode(@Param("sysCode") String username);


    /**
     * 查询系统用户列表
     *
     * @param sysName 系统用户名
     */
    List<SysUser> selectSysUser(@Param("sysName") String sysName);

}