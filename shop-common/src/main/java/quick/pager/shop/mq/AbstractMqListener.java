package quick.pager.shop.mq;

import com.rabbitmq.client.Channel;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;

/**
 * 抽象实现MQ自定义监听器接口<br />
 * 包含实现消息确认，以及业务处理异常场景
 *
 * @param <T>
 * @author siguiyang
 */
@Slf4j
public abstract class AbstractMqListener<T> implements IListener<T> {


    @RabbitHandler
    @Override
    public void process(T obj, Message message, Channel channel) throws Exception {
        // 确认消息
        this.basicAck(channel, message.getMessageProperties().getDeliveryTag());

        if (!this.doProcess(obj, message, channel)) {
            log.error("消息确认失败未消费");
            // 处理业务发生异常，不消费消息，可重新再次消费消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
    }

    @Override
    public void basicAck(Channel channel, long deliveryTag) {
        try {
            log.info("消息确认成功已消费");
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            log.error("消息确认失败未消费");
            try {
                // 重新接收消息，不消费此消息
                channel.basicNack(deliveryTag, false, true);
            } catch (IOException e1) {
                log.error("重新发送消息失败。。。");
            }
        }
    }
}
