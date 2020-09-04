package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 表元素
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Tables extends Model {

    private static final long serialVersionUID = 2230728377435647289L;

    @TableField("TABLE_SCHEMA")
    private String tableSchema;
    @TableField("TABLE_NAME")
    private String tableName;
    @TableField("TABLE_COMMENT")
    private String tableComment;

}
