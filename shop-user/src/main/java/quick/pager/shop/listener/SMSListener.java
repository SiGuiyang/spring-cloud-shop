package quick.pager.shop.listener;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.constants.RabbitMqKeys;
import quick.pager.shop.dto.SmsDTO;
import quick.pager.shop.mq.AbstractMqListener;
import quick.pager.shop.utils.SMSUtil;

/**
 * 短信监听
 *
 * @author siguiyang
 */
@Component
@RabbitListener(queues = RabbitMqKeys.SEND_SMS)
@Slf4j
public class SMSListener extends AbstractMqListener<SmsDTO> {

    @Override
    public boolean doProcess(SmsDTO smsdto, Message message, Channel channel) {
        log.info("短信接收的参数 params = {}, correlationData = {}", JSON.toJSONString(smsdto), message.getMessageProperties().getCorrelationId());
        if (ObjectUtils.isEmpty(smsdto)) {
            return true;
        }

        SMSUtil.send(smsdto.getPhone(), smsdto.getContent());
        return true;
    }
}
