package quick.pager.shop.listener.goods;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface GoodsMQ {

    String GREETING = "helloTest";

    @Input(GREETING)
    SubscribableChannel greeting();
}
