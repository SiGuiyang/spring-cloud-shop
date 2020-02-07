package quick.pager.shop.activity.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import quick.pager.shop.activity.model.AssembleActivityMember;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;

/**
 * 拼团活动成员
 *
 * @author siguiyang
 */
@Mapper
public interface AssembleActivityMemberMapper extends BaseMapper<AssembleActivityMember> {


    /**
     * 评团成员总数
     *
     * @param wrapper 动态sql参数表
     * @return 总数
     */
    @Select("select count(t.id) from t_assemble_activity_member t " +
            "left join t_assemble_activity_record t1 on t.record_id = t1.id where ${ew.sqlSegment}")
    int selectCounts(@Param(Constants.WRAPPER) Wrapper wrapper);

    /**
     * 评团成员列表
     *
     * @param page    分页参数
     * @param wrapper 动态sql参数表
     * @return 评团成员列表
     */
    @Select("select t.id,t.activity_id as activityId,t.record_id as recordId,t.user_id as userId," +
            "t.phone,t.username,t.`master`,t.create_time as createTime,t1.group_time as groupTime," +
            "t1.`status` from t_assemble_activity_member t " +
            "left join t_assemble_activity_record t1 on t.record_id = t1.id where ${ew.sqlSegment}")
    IPage<AssembleMemberResponse> selectPages(IPage<AssembleMemberResponse> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
