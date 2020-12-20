package quick.pager.shop.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息队列
 *
 * @author siguiyang
 */
public interface PlatformMQ {

    /**
     * 发送短信队列
     */
    String PLATFORM_SEND_SMS_OUTPUT = "platform-send-sms-output";

    @Output(PLATFORM_SEND_SMS_OUTPUT)
    MessageChannel sendSMS();
}
