package quick.pager.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.mq.GoodsMQ;

/**
 * @author siguiyang
 */
@SpringCloudApplication
@EnableFeignClients
@EnableBinding(GoodsMQ.class)
@RestController
public class Goods {

    public static void main(String[] args) {
        SpringApplication.run(Goods.class, args);
    }


    @Autowired
    private GoodsMQ goodsMQ;

    @GetMapping("hello")
    public String hello() {
        boolean send = goodsMQ.greeting().send(MessageBuilder.withPayload("ewewewewewew").build());
        if (send) {
            System.out.println("fasongchengogn");
        }
        return "success";
    }
}

