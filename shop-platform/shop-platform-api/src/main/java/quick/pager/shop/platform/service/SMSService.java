package quick.pager.shop.platform.service;

import quick.pager.shop.response.Response;

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
     * @param event 事件源
     * @return 验证码
     */
    Response<String> sendSms(String phone, String event);
}
