package quick.pager.shop.platform.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.platform.fallback.SMSFallback;
import quick.pager.shop.user.response.Response;

/**
 * 短信对外开放接口
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.PLATFORM_CLIENT, path = ConstantsClient.PLATFORM, fallbackFactory = SMSFallback.class)
public interface SMSClient {

    /**
     * 发送短信
     *
     * @param phone  手机号码
     * @param source 事件源
     * @return 响应对象
     */
    @RequestMapping(value = "/sms/send", method = RequestMethod.POST)
    Response<String> sendSms(@RequestParam("phone") final String phone, @RequestParam("source") final String source);
}
