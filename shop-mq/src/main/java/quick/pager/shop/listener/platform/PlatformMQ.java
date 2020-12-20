package quick.pager.shop.listener.platform;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息队列
 *
 * @author siguiyang
 */
public interface PlatformMQ {

    /**
     * 监听发送短信队列
     */
    String PLATFORM_SEND_SMS_INPUT = "platform-send-sms-input";

    @Input(PLATFORM_SEND_SMS_INPUT)
    SubscribableChannel receiveSMS();
}
