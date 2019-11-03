package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_system_config")
public class SystemConfig extends Model {
    private static final long serialVersionUID = 975311331952447054L;

    private String configName;

    private String configType;

    private String configValue;

    private String module;

    private String description;

}
