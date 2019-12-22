package quick.pager.shop.goods.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.goods.client.ClassificationClient;

@Slf4j
@Component
public class ClassificationClientFallbackFactory implements FallbackFactory<ClassificationClient> {
    @Override
    public ClassificationClient create(Throwable cause) {
        return null;
    }
}
