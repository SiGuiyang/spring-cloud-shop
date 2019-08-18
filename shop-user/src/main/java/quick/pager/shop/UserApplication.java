package quick.pager.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import quick.pager.shop.mq.KafkaService;
import quick.pager.shop.mq.MqMessage;

/**
 * @author siguiyang
 */
@SpringCloudApplication
@EnableFeignClients
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class UserApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Autowired
    private KafkaService kafkaService;

    @Override
    public void run(String... args) throws Exception {

        kafkaService.sender(MqMessage.builder().queueName("sms_send").payLoad("发送短信服务").build());

    }
}

