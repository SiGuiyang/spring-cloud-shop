package quick.pager.shop.platform.service.impl;

import cn.hutool.core.util.RandomUtil;
import java.util.Objects;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.configuration.ShopRedisTemplate;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.platform.enums.SMSCodeEnums;
import quick.pager.shop.platform.response.SMSTemplateResponse;
import quick.pager.shop.platform.service.SMSService;
import quick.pager.shop.platform.service.SMSTemplateService;
import quick.pager.shop.response.Response;

/**
 * 短信
 *
 * @author siguiyang
 */
@Service
public class SMSServiceImpl implements SMSService {

    @Autowired
    private SMSTemplateService smsTemplateService;
    @Autowired
    private ShopRedisTemplate shopRedisTemplate;

    @Override
    public Response<String> sendSms(String phone, String event) {

        SMSCodeEnums smsCodeEnums = EnumUtils.getEnum(SMSCodeEnums.class, event);

        if (Objects.isNull(smsCodeEnums)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "未找到短信发送渠道");
        }

        Response<SMSTemplateResponse> templateResponse = smsTemplateService.sms(smsCodeEnums.getCode());

        // 模板查询未成功
        if (ResponseStatus.Code.SUCCESS != templateResponse.getCode()) {
            return new Response<>(templateResponse.getCode(), templateResponse.getMsg());
        }

        String content = templateResponse.getData().getTemplateContent();

        return new Response<>(getContent(smsCodeEnums, content, phone));
    }


    /**
     * 根据短信渠道获取真实发送的短信内容
     *
     * @param smsCodeEnums 短信渠道枚举
     * @param content      短信模板内容
     * @param phone        手机号码
     * @return 短信发送内容
     */
    private String getContent(SMSCodeEnums smsCodeEnums, String content, String phone) {

        switch (smsCodeEnums) {
            case LOGIN_SMS:
                String code = RandomUtil.randomString(RandomUtil.BASE_NUMBER, 6);
                shopRedisTemplate.opsForValue().set("sms:login:code" + phone, code, 10 * 60);
                content = String.format(content, code);
                break;
            case REGISTER_SMS:
                break;
            case FORGET_SMS:
                break;
            case INITIAL_CIPHER_SMS:
                break;
        }
        return content;
    }
}
