package quick.pager.shop.mapper;

import java.util.List;

import quick.pager.shop.model.risk.BlackList;

/**
* @author siguiyang
*/
public interface BlackListMapper {

    int insertSelective(BlackList record);

    BlackList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlackList record);
    /**
     * 表格查询
     */
    List<BlackList> select(BlackList record);
}
