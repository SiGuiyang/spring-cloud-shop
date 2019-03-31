package quick.pager.shop.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quick.pager.shop.constants.RabbitMqKeys;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue sendSMS() {
        return new Queue(RabbitMqKeys.SEND_SMS);
    }
}
