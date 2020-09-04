package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 配置项
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_system_config")
public class SystemConfig extends Model {
    private static final long serialVersionUID = 975311331952447054L;

    private String configName;

    private String configType;

    private String description;

    private Boolean configStatus;

}
