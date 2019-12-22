package quick.pager.shop.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author siguiyang
 */

@SpringBootApplication(scanBasePackages = "quick.pager.shop")
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients("quick.pager.shop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SellerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class, args);
    }

}

