package quick.pager.shop.configuration;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.util.CollectionUtils;

/**
 * 资源服务器配置
 *
 * @author siguiyang
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(OAuth2Properties.class)
public class OAuth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * 默认无权限路由配置
     */
    private static final String[] DEFAULT_MATCHERS = new String[]{"/oauth/**", "/actuator/**", "/druid/**", "/css/**", "/admin/permit/**"};
    @Autowired
    private OAuth2Properties oAuth2Properties;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // 获取不拦截的权限地址
        List<String> permissions = new ArrayList<>();
        if (!CollectionUtils.isEmpty(oAuth2Properties.getPermissions())) {
            permissions.addAll(oAuth2Properties.getPermissions());
        }
        permissions.addAll(Stream.of(DEFAULT_MATCHERS).collect(Collectors.toList()));

        http
                .csrf().disable()
                .authorizeRequests().mvcMatchers(permissions.toArray(new String[0])).permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, ex) -> { // 匿名用户访问无权限返回
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

                    Map<String, Object> result = new HashMap<>();
                    result.put("code", 10000);
                    result.put("msg", "您没有权限访问！");
                    result.put("data", null);
                    result.put("timestamp", System.currentTimeMillis());
                    response.getWriter().println(JSON.toJSONString(result));

                })
                .accessDeniedHandler((request, response, ex) -> { // 具有访问资源的用户但无法访问某些资源返回无权限访问
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

                    Map<String, Object> result = new HashMap<>();
                    result.put("code", 10000);
                    result.put("msg", "您没有权限访问！");
                    result.put("data", null);
                    result.put("timestamp", System.currentTimeMillis());
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().println(JSON.toJSONString(result));

                }).and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

        resources
                .tokenServices(tokenServices())
                .resourceId("users-info");
    }

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
