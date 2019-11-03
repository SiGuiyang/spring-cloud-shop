package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.risk.BlackList;

/**
* @author siguiyang
*/
@Mapper
public interface BlackListMapper extends BaseMapper<BlackList> {

    int insertSelective(BlackList record);

    BlackList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlackList record);
    /**
     * 表格查询
     */
    List<BlackList> select(BlackList record);
}
