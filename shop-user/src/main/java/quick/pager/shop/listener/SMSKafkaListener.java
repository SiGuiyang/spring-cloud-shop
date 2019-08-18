package quick.pager.shop.listener;

import java.util.Optional;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 发送短信
 *
 * @author siguiyang
 */
@Component
public class SMSKafkaListener {


    @KafkaListener(topics = "sms_send")
    public void doProcess(ConsumerRecord<?, ?> record) {
        Optional<?> message = Optional.ofNullable(record.value());

        if (message.isPresent()) {
            Object obj = message.get();
            System.out.println("============" + obj);
        }

    }
}
