package quick.pager.shop.user;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
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
public class UserApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Autowired
    private LoginHandlerInterceptors loginHandlerInterceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptors);
    }

    @Bean
    public HttpMessageConverters fastJsonConfigure(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
        //日期格式化
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        converter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(converter);
    }
}
