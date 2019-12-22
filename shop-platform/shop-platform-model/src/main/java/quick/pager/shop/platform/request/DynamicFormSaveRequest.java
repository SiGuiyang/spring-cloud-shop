package quick.pager.shop.platform.request;

import java.io.Serializable;
import lombok.Data;

/**
 * DynamicFormSaveRequest
 *
 * @author siguiyang
 * @version 3.0
 */
@Data
public class DynamicFormSaveRequest implements Serializable {

    private static final long serialVersionUID = 395898228134136908L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 业务类型
     */
    private String bizType;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
    /**
     * 模型值
     */
    private String model;
    /**
     * 默认值
     */
    private String defaultValue;
    /**
     * 宽度
     */
    private String width;

    /**
     * 远程访问地址
     */
    private String remoteUrl;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 正则表达式名称
     */
    private String pattern;
    /**
     * placeholder
     */
    private String placeholder;
    /**
     * startPlaceholder
     */
    private String startPlaceholder;
    /**
     * endPlaceholder
     */
    private String endPlaceholder;
    /**
     * 时间格式
     */
    private String format;
    /**
     * 组件自定义样式名称
     */
    private String customClass;
    /**
     * 规则
     */
    private String rules;
    /**
     * 最小值
     */
    private Integer min;
    /**
     * 最大值
     */
    private Integer max;
    /**
     * 歩伐
     */
    private Integer step;

    /**
     * 是否是周期范围
     */
    private Boolean beRange;

    private Boolean showInput;

    private Boolean arrowControl;

    /**
     * 禁用标识
     */
    private Boolean disabled;

    private Boolean inline;

    /**
     * 是否只读
     */
    private Boolean readonly;

    private Boolean editable;
    /**
     * 清空标识
     */
    private Boolean clearable;
    /**
     * 时间标识
     */
    private Boolean timestamp;

    private Boolean allowHalf;

    private Boolean showAlpha;
    /**
     * 是否支持多选
     */
    private Boolean multiple;
    /**
     * 是否展示标签名
     */
    private Boolean showLabel;
    /**
     * 是否显示搜索
     */
    private Boolean filterable;
}
