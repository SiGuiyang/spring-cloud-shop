package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.activity.InviteCode;

@Mapper
public interface InviteCodeMapper {

    int insertSelective(InviteCode record);

    InviteCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InviteCode record);

}
