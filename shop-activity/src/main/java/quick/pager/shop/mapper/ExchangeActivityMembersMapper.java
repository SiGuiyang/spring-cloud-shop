package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import java.util.List;

import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.dto.ExchangeMemberDTO;
import quick.pager.shop.model.activity.ExchangeActivityMembers;
import quick.pager.shop.response.ExchangeMemberResponse;

/**
 * @author siguiyang
 */
@Mapper
public interface ExchangeActivityMembersMapper extends BaseMapper<ExchangeActivityMembers> {

    int insertSelective(ExchangeActivityMembers record);

    ExchangeActivityMembers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExchangeActivityMembers record);

    /**
     * 换购记录查询
     */
//    List<ExchangeMemberResponse> select(@Param("activityId") Long activityId, @Param("phone") String phone, @Param("ruleId") Long ruleId);
    IPage<ExchangeMemberDTO> select(IPage<ExchangeMemberDTO> page, @Param(Constants.WRAPPER) QueryWrapper<ExchangeMemberDTO> qw);
}
