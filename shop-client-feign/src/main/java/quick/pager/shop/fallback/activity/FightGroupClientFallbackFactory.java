package quick.pager.shop.fallback.activity;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.client.activity.AssembleClient;

/**
 * 拼团活动
 *
 * @author siguiyang
 */
@Slf4j
@Component
public class FightGroupClientFallbackFactory implements FallbackFactory<AssembleClient> {

    @Override
    public AssembleClient create(Throwable cause) {
        return null;
    }
}
