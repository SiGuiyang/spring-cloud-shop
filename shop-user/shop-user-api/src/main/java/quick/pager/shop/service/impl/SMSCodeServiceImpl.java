package quick.pager.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.platform.client.SMSClient;
import quick.pager.shop.user.request.SmsRequest;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.SMSCodeService;

/**
 * SMSCodeServiceImpl
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private SMSClient smsClient;

    @Override
    public Response<String> send(final SmsRequest request) {
        log.info("发送短信入口，请求参数 phone = {}, source = {}", request.getPhone(), request.getSource());
        return smsClient.sendSms(request.getPhone(), request.getSource());
    }
}
