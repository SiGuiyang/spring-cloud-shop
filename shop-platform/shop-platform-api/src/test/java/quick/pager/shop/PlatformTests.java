package quick.pager.shop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import quick.pager.shop.mq.PlatformMQ;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Platform.class)
public class PlatformTests {

    @Autowired
    private PlatformMQ platformMQ;

    @Test
    public void testSmsMQ() {

        boolean send = platformMQ.sendSMS().send(MessageBuilder.withPayload("测试").build());

        System.out.println(send);
    }
}
