package quick.pager.shop;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author siguiyang
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableAspectJAutoProxy(proxyTargetClass = true)
@MapperScan(basePackages = "quick.pager.shop")
public class SellerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class, args);
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

