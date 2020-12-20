package quick.pager.shop.listener.activity;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

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
