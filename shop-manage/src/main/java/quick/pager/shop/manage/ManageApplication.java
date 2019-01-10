package quick.pager.shop.manage;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import javax.servlet.Filter;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import quick.pager.common.constants.SysConfigKeys;
import quick.pager.common.utils.SysConfigMap;
import quick.pager.shop.manage.filter.PermissionFilter;
import quick.pager.shop.manage.mapper.PermissionMapper;

/**
 * @author siguiyang
 */
@SpringBootApplication
@MapperScan("quick.pager.shop.manage.mapper")
@EnableEurekaClient
@EnableFeignClients
@Slf4j
public class ManageApplication implements CommandLineRunner, WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }

    @Value("${qiniu.access_key}")
    private String qiniuAccessKey;
    @Value("${qiniu.secret_key}")
    private String qiniuSecretKey;
    @Value("${qiniu.bucket}")
    private String qiniuBucket;
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public void run(String... args) throws Exception {
        log.info("开始加载JVM缓存。。。");

        SysConfigMap.put(SysConfigKeys.QINIU_ACCESS_KEY, qiniuAccessKey);
        SysConfigMap.put(SysConfigKeys.QINIU_SECRET_KEY, qiniuSecretKey);
        SysConfigMap.put(SysConfigKeys.QINIU_BUCKET, qiniuBucket);

        log.info("加载JVM缓存结束。。。");
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

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new PermissionFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("permissionFilter");
        return filterRegistrationBean;
    }
}
