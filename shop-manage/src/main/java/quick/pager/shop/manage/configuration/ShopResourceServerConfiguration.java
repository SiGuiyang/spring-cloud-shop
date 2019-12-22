package quick.pager.shop.manage.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * oauth2.0 资源服务器配置
 *
 * @author siguiyang
 * @version 3.0
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ShopResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * 默认无权限路由配置
     */
    private static final String[] DEFAULT_MATCHERS = new String[]{"/actuator/**", "/druid/**", "/css/**", "/admin/permit/**"};

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().mvcMatchers(DEFAULT_MATCHERS).permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }
}
