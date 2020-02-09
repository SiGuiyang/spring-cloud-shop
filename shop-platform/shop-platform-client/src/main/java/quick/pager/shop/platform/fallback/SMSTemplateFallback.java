package quick.pager.shop.platform.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.platform.client.SMSTemplateClient;

/**
 * 短信模板熔断
 *
 * @author siguiyang
 */
@Component
@Slf4j
public class SMSTemplateFallback implements FallbackFactory<SMSTemplateClient> {
    @Override
    public SMSTemplateClient create(Throwable cause) {
        return null;
    }
}
