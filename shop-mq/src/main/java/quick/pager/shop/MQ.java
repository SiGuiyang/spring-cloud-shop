package quick.pager.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import quick.pager.shop.listener.activity.ActivityMQ;
import quick.pager.shop.listener.goods.GoodsMQ;
import quick.pager.shop.listener.platform.PlatformMQ;

/**
 * @author siguiyang
 */
@SpringBootApplication
@EnableBinding(value = {ActivityMQ.class, GoodsMQ.class, PlatformMQ.class})
public class MQ {

    public static void main(String[] args) {
        SpringApplication.run(MQ.class, args);
    }
}
