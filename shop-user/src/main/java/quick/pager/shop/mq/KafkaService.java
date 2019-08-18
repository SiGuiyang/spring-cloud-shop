package quick.pager.shop.mq;

import javax.annotation.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * kafka 生产者
 *
 * @author siguiyang
 */
@Service
public class KafkaService {

    @Resource
    private KafkaTemplate kafkaTemplate;


    public void sender(MqMessage message) {
        kafkaTemplate.send(message.getQueueName(), message.getPayLoad());
    }
}
