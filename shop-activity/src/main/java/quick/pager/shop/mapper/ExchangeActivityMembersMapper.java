package quick.pager.shop.mapper;

import java.util.List;

import quick.pager.shop.model.ExchangeActivityMembers;

/**
* @author siguiyang
*/
public interface ExchangeActivityMembersMapper {

    int insertSelective(ExchangeActivityMembers record);

    ExchangeActivityMembers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExchangeActivityMembers record);
    /**
     * 表格查询
     */
    List<ExchangeActivityMembers> select(ExchangeActivityMembers record);
}
