package quick.pager.shop.user.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quick.pager.common.constants.Constants;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue sendSMS() {
        return new Queue(Constants.RabbitQueue.SEND_SMS);
    }
}
