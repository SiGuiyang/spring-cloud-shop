package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.activity.IntegralLog;

@Mapper
public interface IntegralLogMapper {

    int insertSelective(IntegralLog record);

    IntegralLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IntegralLog record);

}
