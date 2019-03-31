package quick.pager.shop.mq;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * 发送mq消息主体内容
 *
 * @author siguiyang
 */
@Data
@Builder
public class MqMessage implements Serializable {
    private static final long serialVersionUID = -106569581268748240L;

    /**
     * mq routingKey
     */
    private String routingKey;
    /**
     * mq 队列名称
     */
    private String queueName;
    /**
     * mq exchange 通道
     */
    private String exchange;

    /**
     * 发送消息的内容
     */
    private Serializable payLoad;

}
