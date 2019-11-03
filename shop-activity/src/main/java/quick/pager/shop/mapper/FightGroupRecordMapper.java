package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.activity.AssembleActivityRecord;

@Mapper
public interface FightGroupRecordMapper extends BaseMapper<AssembleActivityRecord> {

    int insertSelective(AssembleActivityRecord record);

    AssembleActivityRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AssembleActivityRecord record);

}
