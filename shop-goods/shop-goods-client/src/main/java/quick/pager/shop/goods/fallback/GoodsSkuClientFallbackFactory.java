package quick.pager.shop.goods.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import quick.pager.shop.goods.client.GoodsSkuClient;

@Component
public class GoodsSkuClientFallbackFactory implements FallbackFactory<GoodsSkuClient> {
    @Override
    public GoodsSkuClient create(Throwable cause) {
        return null;
    }
}
