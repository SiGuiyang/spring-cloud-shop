package quick.pager.shop.auth.feign.configuration;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * oauth2 client 配置属性
 *
 * @author siguiyang
 */
@Data
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
}
