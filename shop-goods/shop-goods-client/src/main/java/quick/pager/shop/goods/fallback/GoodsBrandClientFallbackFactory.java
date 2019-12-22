package quick.pager.shop.goods.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.goods.client.GoodsBrandClient;

@Slf4j
@Component
public class GoodsBrandClientFallbackFactory implements FallbackFactory<GoodsBrandClient> {
    @Override
    public GoodsBrandClient create(Throwable cause) {
        return null;
    }
}
