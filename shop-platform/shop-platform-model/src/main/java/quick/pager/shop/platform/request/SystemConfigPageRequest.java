package quick.pager.shop.platform.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 系统配置Page
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfigPageRequest extends PageRequest {
    private static final long serialVersionUID = 1874790892777237625L;

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
