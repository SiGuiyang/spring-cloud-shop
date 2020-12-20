package quick.pager.shop.service;

import quick.pager.shop.user.response.Response;

/**
 * 发送短信
 *
 * @author siguiyang
 */
public interface SMSService {

    /**
     * 发送短信
     *
     * @param phone 手机号码
     * @param source 事件源
     * @return 验证码
     */
    Response<String> sendSms(final String phone,final String source);
}
