package quick.pager.shop.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.util.Assert;

/**
 * feign client 请求拦截器
 * 请求消息头添加 <code>Authorization</code>
 *
 * @author siguiyang
 */
public class AuthFeignRequestInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String BEARER_TOKEN_TYPE = "Bearer";

    private final OAuth2RestTemplate oAuth2RestTemplate;

    public AuthFeignRequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
        Assert.notNull(oAuth2RestTemplate, "Context can not be null");
        this.oAuth2RestTemplate = oAuth2RestTemplate;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, oAuth2RestTemplate.getAccessToken().toString()));
    }
}
