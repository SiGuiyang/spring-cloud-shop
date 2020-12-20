package quick.pager.shop.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface GoodsMQ {

    @Output("helloTest")
    MessageChannel greeting();
}
