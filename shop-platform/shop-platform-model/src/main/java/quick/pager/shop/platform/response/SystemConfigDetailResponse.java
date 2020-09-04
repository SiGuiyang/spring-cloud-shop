package quick.pager.shop.platform.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 系统配置明细
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfigDetailResponse extends BasicResponse {

    private static final long serialVersionUID = -2876381839457142973L;

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
     * 配置项key
     */
    private String configKey;
    /**
     * 配置项状态
     */
    private Boolean configStatus;
}
