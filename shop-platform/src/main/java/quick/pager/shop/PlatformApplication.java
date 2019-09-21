package quick.pager.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * shop 中台服务
 * 无数据源交互
 *
 * @author siguiyang
 */
@SpringCloudApplication
@EnableFeignClients
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }
}
