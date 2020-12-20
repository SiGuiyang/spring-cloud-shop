package quick.pager.shop.configuration;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * oauth2 client 配置属性
 *
 * @author siguiyang
 */
@ConfigurationProperties(prefix = "security.oauth2.client")
public class Oauth2ClientProperties {

    /**
     * 服务名
     */
    private String id;
    /**
     * token 访问地址
     */
    private String accessTokenUri;
    /**
     * 客户端访问Id
     */
    private String clientId;
    /**
     * 客户端访问密钥
     */
    private String clientSecret;
    /**
     * scope 模型
     */
    private List<String> scope;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessTokenUri() {
        return accessTokenUri;
    }

    public void setAccessTokenUri(String accessTokenUri) {
        this.accessTokenUri = accessTokenUri;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public List<String> getScope() {
        return scope;
    }

    public void setScope(List<String> scope) {
        this.scope = scope;
    }
}
