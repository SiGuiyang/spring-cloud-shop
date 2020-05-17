package quick.pager.shop.granter;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

/**
 * 手机号密码授权
 *
 * @author siguiyang
 */
public class PhonePasswordTokenGranter extends AbstractTokenGranter {

    /**
     * 手机号密码授权方式
     */
    private static final String GRANT_TYPE = "phone";

    private final AuthenticationManager authenticationManager;

    public PhonePasswordTokenGranter(AuthenticationManager authenticationManager,
                                     AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory) {
        this(authenticationManager, tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
    }

    protected PhonePasswordTokenGranter(AuthenticationManager authenticationManager, AuthorizationServerTokenServices tokenServices,
                                        ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory, String grantType) {
        super(tokenServices, clientDetailsService, requestFactory, grantType);
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {

        Map<String, String> parameters = new LinkedHashMap<>(tokenRequest.getRequestParameters());
        String username = parameters.get("phone");
        String password = parameters.get("password");
        // Protect from downstream leaks of password
        parameters.remove("password");

        Authentication userAuth = new UsernamePasswordAuthenticationToken(username, password);
        ((AbstractAuthenticationToken) userAuth).setDetails(parameters);
        try {
            userAuth = authenticationManager.authenticate(userAuth);
        } catch (AccountStatusException | BadCredentialsException ase) {
            //covers expired, locked, disabled cases (mentioned in section 5.2, draft 31)
            throw new InvalidGrantException(ase.getMessage());
        } // If the username/password are wrong the spec says we should send 400/invalid grant

        if (userAuth == null || !userAuth.isAuthenticated()) {
            throw new InvalidGrantException("Could not authenticate user: " + username);
        }

        return new OAuth2Authentication(getRequestFactory().createOAuth2Request(client, tokenRequest), userAuth);
    }

}
