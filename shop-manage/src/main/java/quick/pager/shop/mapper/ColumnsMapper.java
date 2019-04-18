package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.Columns;

public interface ColumnsMapper {

    /**
     * 查询表元素
     *
     * @param database  数据库实例
     * @param tableName 表名
     */
    List<Columns> selectColumns(@Param("database") String database, @Param("tableName") String tableName);
}
