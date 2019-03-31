package quick.pager.shop.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.RabbitMqKeys;
import quick.pager.shop.mq.AbstractMqListener;

/**
 * 测试error场景
 */
@Component
@RabbitListener(queues = RabbitMqKeys.TOPIC_TEST)
@Slf4j
public class TestErrorListener extends AbstractMqListener<String> {
    @Override
    public boolean doProcess(String obj, Message message, Channel channel) {
        log.info("接收参数 params = {}", obj);

        return false;
    }
}
