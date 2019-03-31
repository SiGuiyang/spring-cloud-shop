package quick.pager.shop.mq;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import quick.pager.shop.mq.MqMessage;
import quick.pager.shop.utils.DateUtils;

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
     */
    public void sender(MqMessage mqMessage) {
        CorrelationData correlationData = new CorrelationData(RandomUtil.randomUUID());
        rabbitTemplate.convertAndSend(mqMessage.getExchange(), mqMessage.getQueueName(), mqMessage.getPayLoad(), message -> {
            message.getMessageProperties().setTimestamp(DateUtils.now());
            message.getMessageProperties().setMessageId(RandomUtil.randomUUID());
            message.getMessageProperties().setCorrelationId(correlationData.getId());
            return message;
        }, correlationData);
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
    public void returnedMessage(@Nullable Message message, int replyCode, @Nullable String replyText, @Nullable String exchange, @Nullable String routingKey) {
        log.info("消息异常回调 replyCode = {}, replyText = {}, exchange = {}, routingKey = {}", replyCode, replyText, exchange, routingKey);
    }
}
