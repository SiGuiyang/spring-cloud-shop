package quick.pager.shop.configuration;

import java.io.PrintWriter;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import quick.pager.shop.response.Response;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ShopResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setContentType("application/json; charset=utf-8");
                    PrintWriter out = response.getWriter();
                    Response<String> resp = new Response<>();
                    if (authException instanceof InsufficientAuthenticationException) {
                        resp.setCode(201);
                        resp.setMsg("未登陆");
                    } else if (authException instanceof UsernameNotFoundException) {
                        resp.setCode(202);
                        resp.setMsg("用户名不存在");
                    } else if (authException instanceof BadCredentialsException) {
                        resp.setCode(203);
                        resp.setMsg("密码不正确");
                    } else {
                        resp.setCode(204);
                        resp.setMsg("登陆过期");
                    }

                    response.setStatus(200);
                    out.write(new ObjectMapper().writeValueAsString(resp));
                    out.flush();
                    out.close();
                })
                .and()
                .authorizeRequests().mvcMatchers("/actuator/**", "/admin/permit/**").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
