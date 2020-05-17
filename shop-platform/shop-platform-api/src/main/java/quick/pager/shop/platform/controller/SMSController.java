package quick.pager.shop.platform.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.platform.request.sms.SMSRequest;
import quick.pager.shop.platform.service.SMSService;
import quick.pager.shop.response.Response;

/**
 * 短信验证码发送
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.PLATFORM)
public class SMSController {

    @Autowired
    private SMSService smsService;

    /**
     * 发送短信验证码
     *
     * @param request 请求参数
     * @return 验证码
     */
    @PostMapping("/sms/send")
    public Response<String> sendSms(@RequestBody SMSRequest request) {
        if (StringUtils.isEmpty(request.getPhone()) || StringUtils.isEmpty(request.getEvent())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return smsService.sendSms(request.getPhone(), request.getEvent());
    }
}
