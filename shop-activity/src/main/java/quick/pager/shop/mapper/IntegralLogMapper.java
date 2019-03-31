package quick.pager.shop.mapper;

import quick.pager.shop.model.IntegralLog;

public interface IntegralLogMapper {

    int insertSelective(IntegralLog record);

    IntegralLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IntegralLog record);

}