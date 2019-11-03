package quick.pager.shop.fallback.activity;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.client.activity.ExchangeClient;

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
