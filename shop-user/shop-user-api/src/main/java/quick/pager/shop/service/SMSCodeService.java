package quick.pager.shop.service;

import quick.pager.shop.user.request.SmsRequest;
import quick.pager.shop.user.response.Response;

/**
 * 短信发送服务
 *
 * @author siguiyang
 */
public interface SMSCodeService {

    /**
     * 发送短信验证码
     *
     * @param request 请求参数
     * @return 响应
     */
    Response<String> send(final SmsRequest request);
}
