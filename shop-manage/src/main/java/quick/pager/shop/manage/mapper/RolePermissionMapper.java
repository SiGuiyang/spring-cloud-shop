package quick.pager.shop.manage.mapper;

import quick.pager.shop.model.manage.RolePermission;

public interface RolePermissionMapper {

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermission record);

}