package quick.pager.shop.auth.feign.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * oauth2 client 配置属性
 *
 * @author siguiyang
 */
@Data
@ConfigurationProperties(prefix = "shop.oauth2.client")
public class Oauth2ClientProperties {

    private String id;
    private String accessTokenUrl;
    private String clientId;
    private String clientSecret;
    private String clientAuthenticationScheme;
}
