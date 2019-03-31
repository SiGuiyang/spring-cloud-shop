package quick.pager.shop.mapper;

import quick.pager.shop.model.InviteCode;

public interface InviteCodeMapper {

    int insertSelective(InviteCode record);

    InviteCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InviteCode record);

}