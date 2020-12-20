package quick.pager.shop.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ActivityMQ {

    String SEND_STATION_MESSAGE = "SEND_STATION_MESSAGE";

    /**
     * 发送优惠券站内信队列
     */
    @Output(SEND_STATION_MESSAGE)
    MessageChannel sendStationMessage();
}
