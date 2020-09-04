package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 动态表单字段
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_field")
public class Field extends Model {
    private static final long serialVersionUID = -3975742488397836227L;

    /**
     * 表单模型主键
     */
    private Long formId;
    /**
     * 字段类型
     */
    private String type;
    /**
     * 字段标题
     */
    private String title;
}
