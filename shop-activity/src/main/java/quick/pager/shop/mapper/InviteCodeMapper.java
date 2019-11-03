package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.activity.InviteCode;

@Mapper
public interface InviteCodeMapper extends BaseMapper<InviteCode> {

    int insertSelective(InviteCode record);

    InviteCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InviteCode record);

}
