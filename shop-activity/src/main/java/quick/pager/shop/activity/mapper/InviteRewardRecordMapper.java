package quick.pager.shop.activity.mapper;

import quick.pager.shop.model.activity.InviteRewardRecord;

public interface InviteRewardRecordMapper {

    int insertSelective(InviteRewardRecord record);

    InviteRewardRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InviteRewardRecord record);

}