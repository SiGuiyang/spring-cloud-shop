package quick.pager.shop.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 高扩展分布式定时任务启动
 *
 * @author siguiyang
 */
@SpringBootApplication(scanBasePackages = "quick.pager.shop")
@EnableDiscoveryClient
@EnableFeignClients("quick.pager.shop")
public class JobApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }
}
