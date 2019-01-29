package quick.pager.shop.user.mq;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Mq 发送服务
 *
 * @author siguiyang
 */
@Component
@Slf4j
public class MqService implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private RabbitTemplate rabbitTemplate;

    public MqService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setMandatory(true);
    }

    /**
     * 发送MQ服务
     *
     * @param queueName 队列名称
     * @param data      数据源
     */
    public void sender(String queueName, Object data) {
        CorrelationData correlationData = new CorrelationData(RandomUtil.randomUUID());
        rabbitTemplate.convertAndSend("", queueName, data, correlationData);
    }

    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) {
        if (ack) {
            log.info("消息发送成功 CorrelationData = {}", correlationData.getId());
        } else {
            log.info("消息发送失败 CorrelationData = {}", correlationData.getId());
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("消息异常回调 replyCode = {}, replyText = {}, exchange = {}, routingKey = {}", replyCode, replyText, exchange, routingKey);
    }
}
