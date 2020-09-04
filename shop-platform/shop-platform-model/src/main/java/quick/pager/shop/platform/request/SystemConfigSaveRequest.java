package quick.pager.shop.platform.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 系统配置Request
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfigSaveRequest extends Request {

    private static final long serialVersionUID = -5016084514496723473L;

    private Long id;

    private String configName;

    private String configType;

    private String description;

    private Boolean configStatus;
}
