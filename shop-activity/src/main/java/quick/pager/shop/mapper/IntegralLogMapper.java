package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.activity.IntegralLog;

@Mapper
public interface IntegralLogMapper extends BaseMapper<IntegralLog> {

    int insertSelective(IntegralLog record);

    IntegralLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IntegralLog record);

}
