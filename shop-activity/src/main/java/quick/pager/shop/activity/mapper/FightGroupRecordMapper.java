package quick.pager.shop.activity.mapper;

import java.util.List;
import quick.pager.shop.model.activity.FightGroupRecord;

public interface FightGroupRecordMapper {

    int insertSelective(FightGroupRecord record);

    FightGroupRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroupRecord record);

    List<FightGroupRecord> selectFightGroupRecord(Long groupId);
}