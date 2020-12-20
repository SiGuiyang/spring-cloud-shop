package quick.pager.shop.configuration;

import feign.Logger;
import feign.RequestInterceptor;
import java.util.Collections;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.util.CollectionUtils;

/**
 * OAuth2Feign 自动配置
 *
 * @author siguiyang
 */
@Configuration
@EnableConfigurationProperties(Oauth2ClientProperties.class)
public class OAuth2FeignAutoConfiguration {

    @Autowired
    private Oauth2ClientProperties oauth2ClientProperties;
    @Autowired
    private OkHttpClient okHttpClient;

    /**
     * Resource details client credentials resource details.
     *
     * @return the client credentials resource details
     */
    @Bean("resourceOwnerPasswordResourceDetails")
    public ClientCredentialsResourceDetails resourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setAccessTokenUri(oauth2ClientProperties.getAccessTokenUri());
        details.setClientId(oauth2ClientProperties.getClientId());
        details.setClientSecret(oauth2ClientProperties.getClientSecret());
        details.setClientAuthenticationScheme(AuthenticationScheme.header);
        details.setScope(!CollectionUtils.isEmpty(oauth2ClientProperties.getScope()) ? oauth2ClientProperties.getScope() : Collections.singletonList("app"));

        return details;
    }

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate() {
        final OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resourceDetails(), new DefaultOAuth2ClientContext());
        oAuth2RestTemplate.setRequestFactory(new OkHttp3ClientHttpRequestFactory(okHttpClient));

        return oAuth2RestTemplate;

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
