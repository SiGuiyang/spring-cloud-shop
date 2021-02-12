package quick.pager.shop.controller.app;

import cn.hutool.core.lang.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.user.request.SmsRequest;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.SMSCodeService;
import quick.pager.shop.utils.Assert;

/**
 * 用户验证码方面的接口
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class AppUserCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    /**
     * 发送短信验证码
     *
     * @param request 请求参数
     */
    @PostMapping("/app/send/code/sms")
    public Response sendSMS(@RequestBody SmsRequest request) {

        Assert.isTrue(StringUtils.isNoneEmpty(request.getPhone()), () -> "手机号不能为空");
        Assert.isTrue(Validator.isMobile(request.getPhone()), () -> "手机号码不正确");
        Assert.isTrue(StringUtils.isNoneEmpty(request.getSource()), () -> "事件源不能为空");

        return smsCodeService.send(request);
    }
}
