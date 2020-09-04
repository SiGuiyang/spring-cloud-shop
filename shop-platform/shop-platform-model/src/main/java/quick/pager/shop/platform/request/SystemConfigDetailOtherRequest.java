package quick.pager.shop.platform.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * SystemConfigDetailOtherRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfigDetailOtherRequest extends Request {
    private static final long serialVersionUID = 8160506120036646842L;
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
    private String configKey;
}
