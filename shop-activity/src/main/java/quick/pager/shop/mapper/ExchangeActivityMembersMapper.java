package quick.pager.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.ExchangeActivityMembers;
import quick.pager.shop.response.ExchangeMemberResponse;

/**
 * @author siguiyang
 */
@Mapper
public interface ExchangeActivityMembersMapper {

    int insertSelective(ExchangeActivityMembers record);

    ExchangeActivityMembers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExchangeActivityMembers record);

    /**
     * 换购记录查询
     */
    List<ExchangeMemberResponse> select(@Param("activityId") Long activityId, @Param("phone") String phone, @Param("ruleId") Long ruleId);
}
