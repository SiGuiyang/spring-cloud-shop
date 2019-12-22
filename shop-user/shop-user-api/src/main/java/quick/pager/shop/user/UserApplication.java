package quick.pager.shop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import quick.pager.shop.mq.MqMessage;
import quick.pager.shop.user.mq.KafkaService;

/**
 * @author siguiyang
 */
@SpringBootApplication(scanBasePackages = "quick.pager.shop")
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients("quick.pager.shop")
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

