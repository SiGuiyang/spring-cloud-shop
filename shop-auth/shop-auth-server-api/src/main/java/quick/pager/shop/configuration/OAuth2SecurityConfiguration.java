package quick.pager.shop.configuration;

import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenGranter;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeTokenGranter;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import quick.pager.shop.model.UserDTO;
import quick.pager.shop.granter.PhonePasswordTokenGranter;
import quick.pager.shop.granter.SmsTokenGranter;
import quick.pager.shop.model.LoginUser;
import quick.pager.shop.service.UserServiceImpl;
import quick.pager.shop.translator.DefaultWebResponseExceptionTranslator;

/**
 * OAuth security 配置
 *
 * @author siguiyang
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2SecurityConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private DefaultWebResponseExceptionTranslator webResponseExceptionTranslator;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetails());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .authorizationCodeServices(authorizationCodeServices)
                .exceptionTranslator(webResponseExceptionTranslator)
                .tokenServices(tokenServices())
                .tokenStore(tokenStore())
                .userDetailsService(userServiceImpl)
                .tokenGranter(new CompositeTokenGranter(getTokenGranters(endpoints.getAuthorizationCodeServices(), endpoints.getTokenServices(), endpoints.getClientDetailsService(), endpoints.getOAuth2RequestFactory())))
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    private List<TokenGranter> getTokenGranters(AuthorizationCodeServices authorizationCodeServices,
                                                AuthorizationServerTokenServices tokenServices,
                                                ClientDetailsService clientDetailsService,
                                                OAuth2RequestFactory requestFactory) {
        return Stream.of(
                new ClientCredentialsTokenGranter(tokenServices, clientDetailsService, requestFactory),
                new ResourceOwnerPasswordTokenGranter(authenticationManager, tokenServices, clientDetailsService, requestFactory),
                new PhonePasswordTokenGranter(authenticationManager, tokenServices, clientDetailsService, requestFactory),
                new AuthorizationCodeTokenGranter(tokenServices, authorizationCodeServices, clientDetailsService, requestFactory),
                new SmsTokenGranter(userServiceImpl, tokenServices, clientDetailsService, requestFactory))
                .collect(Collectors.toList());
    }

    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setClientDetailsService(clientDetails());
        tokenServices.setAccessTokenValiditySeconds(60 * 60 * 24);
        tokenServices.setTokenEnhancer((accessToken, authentication) -> {
            Object principal = authentication.getPrincipal();
            final Map<String, Object> additionalInfo = new HashMap<>();
            if (principal instanceof UserDTO) {
                UserDTO userDTO = (UserDTO) principal;
                additionalInfo.put("profile", LoginUser.builder()
                        .id(userDTO.getId())
                        .phone(userDTO.getUsername())
                        .username(userDTO.getNickName())
                        .avatar(userDTO.getAvatar())
                        .authorities(Optional.ofNullable(userDTO.getAuthorities()).orElse(Lists.newArrayList()).stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                        .token(accessToken.getValue())
                        .build());

            } else if (principal instanceof LoginUser) {
                LoginUser user = (LoginUser) principal;
                user.setToken(accessToken.getValue());
                additionalInfo.put("profile", user);
            }

            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        });
        return tokenServices;

    }
}
