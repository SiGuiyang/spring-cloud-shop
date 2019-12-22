package quick.pager.shop.risk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.risk.model.BlackList;

/**
 * @author siguiyang
 */
@Mapper
public interface BlackListMapper extends BaseMapper<BlackList> {

    BlackList selectByPrimaryKey(Long id);

    /**
     * 表格查询
     */
    List<BlackList> select(BlackList record);
}
