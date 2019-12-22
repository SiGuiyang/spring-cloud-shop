package quick.pager.shop.activity.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.activity.client.ExchangeClient;

/**
 * 满赠换购模块
 *
 * @author siguiyang
 */
@Slf4j
@Component
public class ExchangeClientFallbackFactory implements FallbackFactory<ExchangeClient> {

    @Override
    public ExchangeClient create(Throwable cause) {
        return null;
    }
}
