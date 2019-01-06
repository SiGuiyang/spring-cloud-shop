package quick.pager.shop.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import quick.pager.shop.user.handler.LoginHandlerInterceptors;

/**
 * @author siguiyang
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAspectJAutoProxy(proxyTargetClass = true)
@MapperScan(basePackages = "quick.pager.shop.user")
public class UserApplication implements WebMvcConfigurer{

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginHandlerInterceptors handler = new LoginHandlerInterceptors();
        registry.addInterceptor(handler);
    }
}
