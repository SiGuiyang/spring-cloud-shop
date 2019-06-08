package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.activity.FightGroupRecord;

@Mapper
public interface FightGroupRecordMapper {

    int insertSelective(FightGroupRecord record);

    FightGroupRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroupRecord record);

}
