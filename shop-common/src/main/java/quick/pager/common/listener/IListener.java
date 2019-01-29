package quick.pager.common.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * rabbitMq 基础监听器服务接口 <br />
 * 所有业务接口都应实现此接口
 *
 * @param <T> 消息返回的泛型对象
 * @author siguiyang
 */
@FunctionalInterface
public interface IListener<T> {

    /**
     * 接收消息监听的主方法
     *
     * @param obj         接收的消息
     * @param channel     消息渠道
     * @param deliveryTag deliveryTag
     */
    void doProcess(T obj, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag);
}
