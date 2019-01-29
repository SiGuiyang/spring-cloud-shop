package quick.pager.shop.manage;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import quick.pager.common.constants.SysConfigKeys;
import quick.pager.common.utils.SysConfigMap;

/**
 * @author siguiyang
 */
@SpringBootApplication(scanBasePackages = {"quick.pager.common", "quick.pager.shop.manage","quick.pager.shop.feign.fallback"})
@MapperScan(basePackages = "quick.pager.shop.manage.mapper")
@EnableDiscoveryClient
@EnableFeignClients({"quick.pager.shop.feign"})
@EnableCircuitBreaker
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


    @Override
    public void run(String... args) throws Exception {
        log.info("开始加载JVM缓存。。。");

        SysConfigMap.put(SysConfigKeys.QINIU_ACCESS_KEY, qiniuAccessKey);
        SysConfigMap.put(SysConfigKeys.QINIU_SECRET_KEY, qiniuSecretKey);
        SysConfigMap.put(SysConfigKeys.QINIU_BUCKET, qiniuBucket);

        log.info("加载JVM缓存结束。。。");
    }

    @Bean
    @ConditionalOnClass(HystrixMetricsStreamServlet.class)
    public ServletRegistrationBean registrationBean() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
