package quick.pager.shop.mq.listener;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.Constants;
import quick.pager.common.dto.SmsDTO;
import quick.pager.common.utils.SMSUtil;
import quick.pager.shop.mq.listener.base.IListener;

/**
 * 短信监听
 */
@Component
@RabbitListener(queues = Constants.RabbitQueue.SEND_SMS)
@Slf4j
public class SMSListener implements IListener<SmsDTO> {

    @RabbitHandler
    @Override
    public void doProcess(SmsDTO smsdto, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        log.info("短信接收的参数 params = {}", JSON.toJSONString(smsdto));
        try {
            if (ObjectUtils.isEmpty(smsdto)) {
                return;
            }

            SMSUtil.send(smsdto.getPhone(), smsdto.getContent());

            log.info("消息确认成功已消费");
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error("消息确认失败未消费");
            try {
                channel.basicNack(deliveryTag, false, true);
            } catch (IOException e1) {
                log.error("重新发送消息失败。。。");
            }
        }
    }
}
