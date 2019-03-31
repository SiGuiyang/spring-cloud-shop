package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.FightGroup;

public interface FightGroupMapper {

    int insertSelective(FightGroup record);

    FightGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroup record);

    List<FightGroup> selectFightGroup(@Param("activityName") String activityName, @Param("beginTime") String beginTime,
                                      @Param("endTime") String endTime);
}