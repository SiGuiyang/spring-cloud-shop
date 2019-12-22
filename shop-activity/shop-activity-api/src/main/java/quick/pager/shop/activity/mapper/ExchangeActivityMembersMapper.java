package quick.pager.shop.activity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.activity.model.ExchangeActivityMembers;

/**
 * @author siguiyang
 */
@Mapper
public interface ExchangeActivityMembersMapper extends BaseMapper<ExchangeActivityMembers> {

    /**
     * 换购记录查询
     */
//    List<ExchangeMemberResponse> select(@Param("activityId") Long activityId, @Param("phone") String phone, @Param("ruleId") Long ruleId);
//    IPage<ExchangeMemberDTO> select(IPage<ExchangeMemberDTO> page, @Param(Constants.WRAPPER) QueryWrapper<ExchangeMemberDTO> qw);
}
