package quick.pager.shop.goods.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.goods.client.GoodsBrandGroupClient;

@Slf4j
@Component
public class GoodsBrandGroupClientFallbackFactory implements FallbackFactory<GoodsBrandGroupClient> {
    @Override
    public GoodsBrandGroupClient create(Throwable cause) {
        return null;
    }
}
