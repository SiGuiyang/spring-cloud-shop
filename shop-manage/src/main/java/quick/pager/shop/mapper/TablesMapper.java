package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.Tables;
@Mapper
public interface TablesMapper {

    /**
     * 查询表
     *
     * @param database  数据库实例
     * @param tableName 表名
     */
    List<Tables> selectTables(@Param("database") String database, @Param("tableName") String tableName);
}
