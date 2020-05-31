package quick.pager.shop.platform.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字段属性
 *
 * @author siguiyang
 */
@Data
public class FieldPropsResponse {
    private static final long serialVersionUID = 4059175790298442950L;

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
     * 数值精度
     */
    private Integer precision;
    /**
     * 数据源
     */
    private String datasource;
}
