package quick.pager.shop.activity.listener;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.Constants;
import quick.pager.common.dto.SMSDTO;
import quick.pager.common.utils.SMSUtil;

/**
 * 短信监听
 */
@Component
@RabbitListener(queues = Constants.RabbitQueue.SEND_SMS)
@Slf4j
public class SMSListener {

    @RabbitHandler
    public void doProcess(SMSDTO smsdto) {
        log.info("短信接收的参数 params = {}", JSON.toJSONString(smsdto));

        if (ObjectUtils.isEmpty(smsdto)) {
            return;
        }

        String send = SMSUtil.send(smsdto.getPhone(), smsdto.getContent());
        if ("".equals(send)) {

        }
    }
}
