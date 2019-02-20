package quick.pager.shop.seller.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quick.pager.common.constants.RabbitMqKeys;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue sendSMS() {
        return new Queue(RabbitMqKeys.SEND_SMS);
    }
}
