package quick.pager.shop.mapper;

import java.util.List;

import quick.pager.shop.model.InviteCode;

/**
* @author siguiyang
*/
public interface InviteCodeMapper {

    int insertSelective(InviteCode record);

    InviteCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InviteCode record);
    /**
     * 表格查询
     */
    List<InviteCode> select(InviteCode record);
}
