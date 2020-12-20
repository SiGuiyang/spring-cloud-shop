package quick.pager.shop.granter;

import com.google.common.collect.Lists;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import quick.pager.shop.model.LoginUser;
import quick.pager.shop.service.UserServiceImpl;

/**
 * 短信码授权登陆
 *
 * @author siguiyang
 */
public class SmsTokenGranter extends AbstractTokenGranter {

    /**
     * 短信授权方式
     */
    private static final String GRANT_TYPE = "sms";

    private UserServiceImpl userService;

    private OAuth2RequestFactory requestFactory;

    public SmsTokenGranter(UserServiceImpl userService, AuthorizationServerTokenServices tokenServices,
                           ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory) {
        this(tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
        this.userService = userService;
    }

    protected SmsTokenGranter(AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService,
                              OAuth2RequestFactory requestFactory, String grantType) {
        super(tokenServices, clientDetailsService, requestFactory, grantType);
        this.requestFactory = requestFactory;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> parameters = new LinkedHashMap<>(tokenRequest.getRequestParameters());
        String phone = parameters.get("phone");
        String smsCode = parameters.get("smsCode");
        LoginUser loginUser = userService.loadUserBySMS(phone, smsCode);
        PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(loginUser, null, Lists.newArrayList());
        authentication.setDetails(parameters);
        return new OAuth2Authentication(this.requestFactory.createOAuth2Request(client, tokenRequest), authentication);
    }

    @Override
    public OAuth2RequestFactory getRequestFactory() {
        return requestFactory;
    }

    public void setRequestFactory(OAuth2RequestFactory requestFactory) {
        this.requestFactory = requestFactory;
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setLoginService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
