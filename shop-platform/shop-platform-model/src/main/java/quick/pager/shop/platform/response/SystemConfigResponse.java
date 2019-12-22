package quick.pager.shop.platform.response;

import java.io.Serializable;
import lombok.Data;

/**
 * 系统配置
 *
 * @author siguiyang
 */
@Data
public class SystemConfigResponse implements Serializable {

    private static final long serialVersionUID = -2876381839457142973L;

    private Long id;

    private String configName;

    private String configType;

    private String configValue;

    private String module;

    private String description;

    private Boolean configStatus;
}
