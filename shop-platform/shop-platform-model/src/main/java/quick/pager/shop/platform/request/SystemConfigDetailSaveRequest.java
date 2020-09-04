package quick.pager.shop.platform.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * SystemConfigDetailSaveRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfigDetailSaveRequest extends Request {
    private static final long serialVersionUID = -5384653263638125236L;
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
