package quick.pager.shop.configuration;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 不需要权限访问配置
 *
 * @author siguiyang
 */
@ConfigurationProperties(OAuth2Properties.PREFIX)
public class OAuth2Properties {

    static final String PREFIX = "shop.oauth";
    /**
     * 非权限验证路由
     */
    private List<String> permissions;


    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
