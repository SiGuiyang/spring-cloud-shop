package quick.pager.shop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import quick.pager.shop.filter.ShopUsernamePasswordAuthenticationFilter;
import quick.pager.shop.handler.ShopAuthenticationSuccessHandler;
import quick.pager.shop.security.ShopLoginUrlAuthenticationEntryPoint;
import quick.pager.shop.service.UserService;

@Configuration
@EnableWebSecurity
public class Auth2SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .addFilterAt(shopUsernamePasswordAuthenticationFilter(), ShopUsernamePasswordAuthenticationFilter.class)
                .formLogin().permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(shopLoginUrlAuthenticationEntryPoint())
                .and()
                .logout().logoutUrl("/logout").deleteCookies("JSESSIONID").invalidateHttpSession(true).permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/css/**", "/images/**", "/js/**", "/index.html", "/webjars/**", "/oauth/login", "/actuator/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public ShopAuthenticationSuccessHandler shopAuthenticationSuccessHandler() {
        return new ShopAuthenticationSuccessHandler();
    }

    @Bean
    public ShopUsernamePasswordAuthenticationFilter shopUsernamePasswordAuthenticationFilter() throws Exception {

        ShopUsernamePasswordAuthenticationFilter shopUsernamePasswordAuthenticationFilter = new ShopUsernamePasswordAuthenticationFilter();
        shopUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(shopAuthenticationSuccessHandler());
        shopUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        shopUsernamePasswordAuthenticationFilter.setFilterProcessesUrl("/oauth/login");
        return shopUsernamePasswordAuthenticationFilter;
    }

    public ShopLoginUrlAuthenticationEntryPoint shopLoginUrlAuthenticationEntryPoint() {
        return new ShopLoginUrlAuthenticationEntryPoint("/");
    }
}
