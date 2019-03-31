package quick.pager.shop.mapper;

import quick.pager.shop.model.InviteRewardRecord;

public interface InviteRewardRecordMapper {

    int insertSelective(InviteRewardRecord record);

    InviteRewardRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InviteRewardRecord record);

}