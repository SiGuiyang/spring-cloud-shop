package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.FightGroupMember;
import quick.pager.shop.response.FightGroupMemberResponse;

@Mapper
public interface FightGroupMemberMapper {

    int insertSelective(FightGroupMember record);

    FightGroupMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroupMember record);

    /**
     * 拼团成员
     */
    List<FightGroupMember> selectFightGroupMember(@Param("recordId") Long recordId);

    List<FightGroupMemberResponse> selectFightGroupRecord(@Param("activityId") Long activityId, @Param("phone") String phone);


}
