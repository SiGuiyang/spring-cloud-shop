package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.FightGroupRecord;

public interface FightGroupRecordMapper {

    int insertSelective(FightGroupRecord record);

    FightGroupRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroupRecord record);

    List<FightGroupRecord> selectFightGroupRecord(@Param("groupId") Long groupId, @Param("beginTime") String beginTime, @Param("endTime") String endTime);
}