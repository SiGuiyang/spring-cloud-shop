package quick.pager.shop.mq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
@Slf4j
public class HelloListener {


    @RabbitHandler
    public void process(String params) {
        log.info("接受消息 {}", params);
        System.out.println(params);
    }
}

