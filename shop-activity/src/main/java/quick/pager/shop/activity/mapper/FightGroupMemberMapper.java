package quick.pager.shop.activity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.FightGroupMember;

public interface FightGroupMemberMapper {

    int insertSelective(FightGroupMember record);

    FightGroupMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FightGroupMember record);

    /**
     * 拼团成员
     */
    List<FightGroupMember> selectFightGroupMember(@Param("recordId") Long recordId);

}