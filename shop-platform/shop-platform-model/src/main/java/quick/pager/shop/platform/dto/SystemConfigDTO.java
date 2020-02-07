package quick.pager.shop.platform.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * 系统配置缓存DTO
 *
 * @author siguiyang
 * @version 3.0
 */
@Data
public class SystemConfigDTO implements Serializable {

    private static final long serialVersionUID = 4632616579129260059L;

    private String configType;

    private String configName;

    private String configValue;

    private String description;
}
