package quick.pager.shop.param.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfigParam extends PageParam {
    private static final long serialVersionUID = -5469712897215941464L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 配置项名称
     */
    private String configName;
    /**
     * 配置项类型
     */
    private String configType;
    /**
     * 配置项值
     */
    private String configValue;
    /**
     * 配置项模块
     */
    private String module;
    /**
     * 配置项模块描述
     */
    private String description;

}
