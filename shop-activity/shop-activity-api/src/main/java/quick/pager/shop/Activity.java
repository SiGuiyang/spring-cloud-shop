package quick.pager.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import quick.pager.shop.mq.ActivityMQ;

/**
 * @author siguiyang
 */
@SpringCloudApplication
@EnableFeignClients
@EnableBinding(ActivityMQ.class)
public class Activity {

    public static void main(String[] args) {
        SpringApplication.run(Activity.class, args);
    }

}
