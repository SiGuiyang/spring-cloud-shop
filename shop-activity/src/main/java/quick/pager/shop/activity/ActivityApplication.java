package quick.pager.shop.activity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author siguiyang
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages = "quick.pager.shop.activity.mapper")
public class ActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class, args);
    }
}
