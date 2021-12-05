package quick.pager.shop.mq.consumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import quick.pager.shop.mq.ActivityMQ;

/**
 * 站内行发送监听器
 *
 * @author siguiyang
 */
@Component
public class SendStationMessageListener {


    @StreamListener(ActivityMQ.SEND_STATION_MESSAGE)
    public void sendStationMessage() {

    }
}
