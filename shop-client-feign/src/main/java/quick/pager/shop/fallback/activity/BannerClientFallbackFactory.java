package quick.pager.shop.fallback.activity;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.client.activity.BannerClient;

/**
 * banner模块熔断工厂
 *
 * @author siguiyang
 */
@Slf4j
@Component
public class BannerClientFallbackFactory implements FallbackFactory<BannerClient> {

    @Override
    public BannerClient create(Throwable cause) {
        return null;
    }
}
