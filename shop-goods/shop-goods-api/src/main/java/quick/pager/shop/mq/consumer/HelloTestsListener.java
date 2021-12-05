package quick.pager.shop.mq.consumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import quick.pager.shop.mq.GoodsMQ;

import java.io.IOException;

@Component
public class HelloTestsListener {


    @StreamListener(target = GoodsMQ.GREETING)
    public void process(@Payload String msg) throws IOException {
        System.out.println("MQ返回消息:" + msg);

    }

}
