package quick.pager.shop.platform.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.platform.client.SMSClient;
import quick.pager.shop.user.response.Response;

@Component
@Slf4j
public class SMSFallback implements FallbackFactory<SMSClient> {

    @Override
    public SMSClient create(Throwable cause) {
        return new SMSClient() {
            @Override
            public Response<String> sendSms(String phone, String source) {
                System.out.println(cause);
                log.error("进入熔断 SMSFallback.sendSms: phone = {}, source = {}", phone, source);
                return Response.toError(ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
