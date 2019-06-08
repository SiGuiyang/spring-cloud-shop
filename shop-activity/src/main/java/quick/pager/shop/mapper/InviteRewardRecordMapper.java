package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.activity.InviteRewardRecord;

@Mapper
public interface InviteRewardRecordMapper {

    int insertSelective(InviteRewardRecord record);

    InviteRewardRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InviteRewardRecord record);

}
