package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_system_config_detail")
public class SystemConfigDetail extends Model {

    private static final long serialVersionUID = -6793985159272670783L;
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
     * 配置项key
     */
    private String configKey;

    /**
     * 配置项状态
     */
    private Boolean configStatus;

}
