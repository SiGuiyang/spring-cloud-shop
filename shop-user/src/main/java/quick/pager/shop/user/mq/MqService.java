package quick.pager.shop.user.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mq 发送服务
 */
@Component
public class MqService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送MQ服务
     *
     * @param queueName 队列名称
     * @param data      数据源
     */
    public void sender(String queueName, Object data) {
        amqpTemplate.convertAndSend(queueName, data);
    }
}
