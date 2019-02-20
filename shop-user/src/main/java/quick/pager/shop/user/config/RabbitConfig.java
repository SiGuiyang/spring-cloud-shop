package quick.pager.shop.user.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quick.pager.common.constants.RabbitMqKeys;

/**
 * Rabbit MQ 配置
 *
 * @author siguiyang
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue sendSMS() {
        return new Queue(RabbitMqKeys.SEND_SMS);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(RabbitMqKeys.TOPIC_EXCHANGE);
    }

    @Bean
    public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with(RabbitMqKeys.TOPIC_COMMON);
    }
}
