package quick.pager.shop.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.ImmutableMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.RedisKeys;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.mq.PlatformMQ;
import quick.pager.shop.platform.enums.SMSCodeEnums;
import quick.pager.shop.platform.response.SMSTemplateResponse;
import quick.pager.shop.service.SMSService;
import quick.pager.shop.service.SMSTemplateService;
import quick.pager.shop.user.response.Response;

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
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private PlatformMQ platformMQ;

    @Override
    public Response<String> sendSms(final String phone, final String event) {

        SMSCodeEnums smsCodeEnums = EnumUtils.getEnum(SMSCodeEnums.class, event);

        if (Objects.isNull(smsCodeEnums)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "未找到短信发送渠道");
        }

        Response<SMSTemplateResponse> templateResponse = smsTemplateService.sms(smsCodeEnums.getCode());

        // 模板查询未成功
        if (!templateResponse.check()) {
            return Response.toError(templateResponse.getCode(), templateResponse.getMsg());
        }

        String content = templateResponse.getData().getTemplateContent();

        String smsContent = getContent(smsCodeEnums, content, phone);

        // 发送消息队列
        platformMQ.sendSMS().send(MessageBuilder.withPayload(ImmutableMap.of("phone", phone, "smsContent", smsContent)).build());

        return Response.toResponse(smsContent);
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
                redisTemplate.opsForValue().set(RedisKeys.REDIS_SMS_LOGIN_PREFIX + phone, code, 10, TimeUnit.MINUTES);
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
