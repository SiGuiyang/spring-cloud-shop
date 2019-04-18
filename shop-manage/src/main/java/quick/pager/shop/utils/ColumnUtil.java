package quick.pager.shop.utils;

import com.google.common.collect.Maps;
import java.util.Map;
import org.apache.ibatis.type.JdbcType;

/**
 * jdbcType 转javaType
 *
 * @author siguiyang
 */
public class ColumnUtil {


    private static final Map<String, String> COLUMN_MAP = Maps.newConcurrentMap();

    static {
        COLUMN_MAP.putIfAbsent("VARCHAR", "String");
        COLUMN_MAP.putIfAbsent("LONGVARCHAR", "String");
        COLUMN_MAP.putIfAbsent("NUMERIC", "java.math.BigDecimal");
        COLUMN_MAP.putIfAbsent("DECIMAL", "java.math.BigDecimal");
        COLUMN_MAP.putIfAbsent("BIT", "Boolean");
        COLUMN_MAP.putIfAbsent("BOOLEAN", "Boolean");
        COLUMN_MAP.putIfAbsent("TINYINT", "Integer");
        COLUMN_MAP.putIfAbsent("SMALLINT", "Integer");
        COLUMN_MAP.putIfAbsent("INTEGER", "Integer");
        COLUMN_MAP.putIfAbsent("BIGINT", "Long");
        COLUMN_MAP.putIfAbsent("DATE", "java.util.Date");
        COLUMN_MAP.putIfAbsent("TIME", "java.util.Date");
        COLUMN_MAP.putIfAbsent("TIMESTAMP", "java.util.Date");

    }


    /**
     * 数据库类型转java类型
     *
     * @param columnType 数据库类型
     */
    public static String column2Java(String columnType) {

        JdbcType[] values = JdbcType.values();

        String result = "";
        for (JdbcType jdbcType : values) {
            if (columnType.equalsIgnoreCase(jdbcType.name())) {

                result = COLUMN_MAP.get(jdbcType.name());
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(column2Java("TIMESTAMP"));
    }

    /**
     * 将类字段名，mybatis jdbcType 转换xml映射方式
     *
     * @param fieldName 类字段名
     * @param colType   类型
     * @return #{id, jdbcType=VARCHAR}
     */
    public static String column2JdbcType(String fieldName, String colType) {

        return "#{" + fieldName + ", " + "jdbcType=" + colType + "}";
    }
}
