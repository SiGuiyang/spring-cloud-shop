package quick.pager.shop.activity.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.activity.client.BannerClient;

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
