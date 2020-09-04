package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import quick.pager.shop.model.JobGroup;

@Mapper
public interface JobGroupMapper extends BaseMapper<JobGroup> {

    @Select("select max(sequence) from QUARTZ_JOB_GROUP")
    int selectMaxSequence();
}
