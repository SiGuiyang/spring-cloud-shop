package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 表属性
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Columns extends Model {
    private static final long serialVersionUID = -782010020592372403L;
    @TableField("TABLE_SCHEMA")
    private String tableSchema;
    @TableField("TABLE_NAME")
    private String tableName;
    @TableField("COLUMN_NAME")
    private String columnName;
    @TableField("DATA_TYPE")
    private String dataType;
    @TableField("COLUMN_TYPE")
    private String columnType;
    @TableField("COLUMN_KEY")
    private String columnKey;
    @TableField("COLUMN_COMMENT")
    private String columnComment;

    private String columnTitle;

    private boolean columnDisplay;

    private boolean queryDisplay;


}
