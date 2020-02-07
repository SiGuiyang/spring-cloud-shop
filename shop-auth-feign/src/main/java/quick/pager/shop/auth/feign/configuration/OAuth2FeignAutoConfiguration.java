package quick.pager.shop.auth.feign.configuration;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import quick.pager.shop.auth.feign.interceptor.AuthFeignRequestInterceptor;

/**
 * OAuth2Feign 自动配置
 *
 * @author siguiyang
 */
@Configuration
@EnableConfigurationProperties(Oauth2ClientProperties.class)
public class OAuth2FeignAutoConfiguration {

    private final Oauth2ClientProperties oauth2ClientProperties;

    /**
     * Instantiates a new O auth 2 feign auto configuration.
     *
     * @param oauth2ClientProperties the oauth 2 client properties
     */
    @Autowired
    public OAuth2FeignAutoConfiguration(Oauth2ClientProperties oauth2ClientProperties) {
        this.oauth2ClientProperties = oauth2ClientProperties;
    }

    /**
     * Resource details client credentials resource details.
     *
     * @return the client credentials resource details
     */
    @Bean("clientCredentialsResourceDetails")
    public ClientCredentialsResourceDetails resourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setId(oauth2ClientProperties.getId());
        details.setAccessTokenUri(oauth2ClientProperties.getAccessTokenUrl());
        details.setClientId(oauth2ClientProperties.getClientId());
        details.setClientSecret(oauth2ClientProperties.getClientSecret());
        details.setAuthenticationScheme(AuthenticationScheme.valueOf(oauth2ClientProperties.getClientAuthenticationScheme()));
        return details;
    }

    /**
     * Oauth 2 feign request interceptor request interceptor.
     *
     * @param oAuth2RestTemplate the o auth 2 rest template
     * @return the request interceptor
     */
    @Bean
    @ConditionalOnClass(OAuth2RestTemplate.class)
    public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
        return new AuthFeignRequestInterceptor(oAuth2RestTemplate);
    }

    /**
     * Feign logger level logger . level.
     *
     * @return the logger . level
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
