package quick.pager.shop.configuration;

import java.net.UnknownHostException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import quick.pager.shop.service.RedisService;

@Configuration
@ConditionalOnClass({RedisTemplate.class, RedisConnectionFactory.class})
public class RedisConfiguration {


    @Bean
    public ShopRedisTemplate shopRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        ShopRedisTemplate template = new ShopRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public RedisService redisService(ShopRedisTemplate shopRedisTemplate) {
        return new RedisService(shopRedisTemplate);
    }
}
