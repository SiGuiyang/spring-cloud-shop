package quick.pager.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author siguiyang
 */

@SpringCloudApplication
@EnableFeignClients
@EnableAspectJAutoProxy(proxyTargetClass = true)
@MapperScan("quick.pager.shop.mapper")
public class SellerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class, args);
    }

}

