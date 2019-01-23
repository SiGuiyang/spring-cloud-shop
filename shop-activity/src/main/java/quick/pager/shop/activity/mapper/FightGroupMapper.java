package quick.pager.shop.activity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.FightGroup;

public interface FightGroupMapper {

    int insertSelective(FightGroup record);

    FightGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroup record);

    List<FightGroup> selectFightGroup(@Param("activityName") String activityName, @Param("beginTime") String beginTime,
                                      @Param("endTime") String endTime);
}