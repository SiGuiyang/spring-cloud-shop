package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.platform.client.SMSClient;
import quick.pager.shop.service.SMSService;
import quick.pager.shop.user.response.Response;

/**
 * 短信验证码发送
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.PLATFORM)
public class SMSController implements SMSClient {

    @Autowired
    private SMSService smsService;

    /**
     * 发送短信验证码
     *
     * @param phone  手机号码
     * @param source 事件源
     * @return 验证码
     */
    @PostMapping("/sms/send")
    @Override
    public Response<String> sendSms(@RequestParam("phone") final String phone, @RequestParam("source") final String source) {
        return smsService.sendSms(phone, source);
    }
}
