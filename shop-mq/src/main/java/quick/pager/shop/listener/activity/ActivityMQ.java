package quick.pager.shop.listener.activity;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 营销模块
 *
 * @author siguiyang
 */
public interface ActivityMQ {

    String SEND_STATION_MESSAGE = "SEND_STATION_MESSAGE";

    /**
     * 发送优惠券站内信队列
     */
    @Input(SEND_STATION_MESSAGE)
    SubscribableChannel sendStationMessage();
}
