package quick.pager.shop.manage.mapper;

import quick.pager.shop.model.manage.SysRole;

public interface SysRoleMapper {

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

}