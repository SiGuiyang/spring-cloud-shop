package quick.pager.shop.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author siguiyang
 */
@SpringBootApplication(scanBasePackages = {"quick.pager.common", "quick.pager.shop.goods"})
@EnableDiscoveryClient
@EnableCircuitBreaker
@MapperScan(basePackages = "quick.pager.shop.goods.mapper")
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

}
