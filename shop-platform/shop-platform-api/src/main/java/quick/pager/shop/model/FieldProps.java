package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字段属性
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_field_props")
public class FieldProps extends Model {
    private static final long serialVersionUID = 5445812830128815821L;

    /**
     * 字段主键
     */
    private Long fieldId;
    /**
     * 类型
     */
    private String type;
    /**
     * 原生属性，最大输入长度
     */
    private Integer maxLength;
    /**
     * 原生属性，最小输入长度
     */
    private Integer minLength;
    /**
     * 输入框占位文本
     */
    private String placeholder;
    /**
     * 是否可清空
     */
    private Boolean clearable;
    /**
     * 禁用
     */
    private Boolean disabled;
    /**
     * 输入框尺寸，只在 type!="textarea" 时有效
     */
    private String size;
    /**
     * 输入框头部图标
     */
    private String prefixIcon;
    /**
     * 输入框尾部图标
     */
    private String suffixIcon;
    /**
     * 输入框行数，只对 type="textarea" 有效
     */
    private Integer rows;
    /**
     * 自适应内容高度，只对 type="textarea" 有效，可传入对象，如，{ minRows: 2, maxRows: 6 }
     */
    private String autosize;
    /**
     * 计数器步长
     */
    private Integer step;
    /**
     * 数据源
     */
    private String datasource;
}
