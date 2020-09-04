package quick.pager.shop.param.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

/**
 * 代码生成
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GeneratorPageParam extends PageParam {
    private static final long serialVersionUID = 9001430976354534713L;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 数据库实例名
     */
    private String tableSchema;


}
