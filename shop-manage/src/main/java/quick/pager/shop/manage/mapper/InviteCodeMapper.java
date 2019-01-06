package quick.pager.shop.manage.mapper;

import quick.pager.shop.model.activity.InviteCode;

public interface InviteCodeMapper {

    int insertSelective(InviteCode record);

    InviteCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InviteCode record);

}