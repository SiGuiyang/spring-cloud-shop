package quick.pager.shop.fallback.goods;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.client.goods.ClassificationClient;

@Slf4j
@Component
public class ClassificationClientFallbackFactory implements FallbackFactory<ClassificationClient> {
    @Override
    public ClassificationClient create(Throwable cause) {
        return null;
    }
}
