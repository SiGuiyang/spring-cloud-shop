package quick.pager.shop.listener.goods;

import java.io.IOException;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class HelloTestsListener {


    @StreamListener(target = GoodsMQ.GREETING)
    public void process(@Payload String msg) throws IOException {
        System.out.println("MQ返回消息:" + msg);

    }

}
