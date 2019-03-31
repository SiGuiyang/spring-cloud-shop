package quick.pager.shop.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

/**
 * rabbitMq 基础监听器服务接口 <br />
 * 所有业务接口都应实现此接口
 *
 * @param <T> 消息返回的泛型对象
 * @author siguiyang
 */
interface IListener<T> {

    /**
     * 接收消息监听的主方法
     *
     * @param obj     接收的消息
     * @param message mq 消息
     * @param channel 消息渠道
     */
    void process(T obj, Message message, Channel channel) throws Exception;

    /**
     * 核心发送到MQ 中处理的业务，由 quick.pager.shop.mq.IListener#process 回调
     *
     * @param obj     核心业务消息
     * @param message mq 消息
     * @param channel 消息渠道
     * @return true 业务返回正常，false 业务返回异常现象，消息失败
     */
    boolean doProcess(T obj, Message message, Channel channel);

    /**
     * 确认消息机制
     *
     * @param channel     消息渠道
     * @param deliveryTag deliveryTag
     */
    void basicAck(Channel channel, long deliveryTag);
}
