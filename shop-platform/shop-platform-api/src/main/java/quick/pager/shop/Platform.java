package quick.pager.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import quick.pager.shop.mq.PlatformMQ;

@SpringCloudApplication
@EnableFeignClients
@EnableBinding(PlatformMQ.class)
public class Platform {

    public static void main(String[] args) {
        SpringApplication.run(Platform.class, args);
    }
}
