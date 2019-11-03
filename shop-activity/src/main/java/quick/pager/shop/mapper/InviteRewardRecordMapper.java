package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.activity.InviteRewardRecord;

@Mapper
public interface InviteRewardRecordMapper extends BaseMapper<InviteRewardRecord> {

    int insertSelective(InviteRewardRecord record);

    InviteRewardRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InviteRewardRecord record);

}
