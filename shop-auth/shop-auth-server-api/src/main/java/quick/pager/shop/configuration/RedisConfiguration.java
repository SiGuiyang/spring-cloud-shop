package quick.pager.shop.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis 配置
 *
 * @author siguiyang
 */
@Configuration
@ConditionalOnClass({RedisTemplate.class, RedisConnectionFactory.class})
public class RedisConfiguration {


    @Bean
    public ShopRedisTemplate shopRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        ShopRedisTemplate template = new ShopRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
