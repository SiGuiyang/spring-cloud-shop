package quick.pager.shop.platform.request;

import java.io.Serializable;
import lombok.Data;

@Data
public class SystemConfigOtherRequest implements Serializable {
    private static final long serialVersionUID = -7012051406995434530L;

    /**
     * 配置项名称
     */
    private String configName;
    /**
     * 配置项类型
     */
    private String configType;

    /**
     * 配置项所属模块
     */
    private String module;
}
