package quick.pager.shop.activity.mapper;

import quick.pager.shop.model.activity.IntegralLog;

public interface IntegralLogMapper {

    int insertSelective(IntegralLog record);

    IntegralLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IntegralLog record);

}