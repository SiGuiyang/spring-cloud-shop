package quick.pager.shop.manage.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.manage.model.Columns;
import quick.pager.shop.manage.model.Tables;

@Mapper
public interface GeneratorMapper {


    /**
     * 查询表
     */
    IPage<Tables> selectTables(IPage<Tables> page, @Param(Constants.WRAPPER) Wrapper<Tables> qw);

    /**
     * 查询表元素
     */
    List<Columns> selectColumns(@Param(Constants.WRAPPER) Wrapper<Columns> qw);
}
