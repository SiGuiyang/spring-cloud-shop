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

@Mapper
public interface AssembleActivityMemberMapper extends BaseMapper<AssembleActivityMember> {


    @Select("select count(t.id) from t_assemble_activity_member t " +
            "left join t_assemble_activity_record t1 on t.record_id = t1.id where ${ew.sqlSegment}")
    int selectCounts(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select("select t.id,t.activity_id as activityId,t.record_id as recordId,t.user_id as userId," +
            "t.phone,t.username,t.`master`,t.create_time as createTime,t1.group_time as groupTime," +
            "t1.`status` from t_assemble_activity_member t " +
            "left join t_assemble_activity_record t1 on t.record_id = t1.id where ${ew.sqlSegment}")
    IPage<AssembleMemberResponse> selectPages(IPage<AssembleMemberResponse> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
