package quick.pager.shop.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author siguiyang
 */
@SpringBootApplication(scanBasePackages = "quick.pager.shop")
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients("quick.pager.shop")
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}

