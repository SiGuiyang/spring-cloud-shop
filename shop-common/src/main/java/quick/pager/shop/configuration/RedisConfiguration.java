package quick.pager.shop.configuration;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import java.nio.charset.StandardCharsets;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis 配置
 *
 * @author siguiyang
 */
@Configuration
@ConditionalOnClass({RedisTemplate.class, RedisConnectionFactory.class})
@AutoConfigureAfter(RedissonAutoConfiguration.class)
public class RedisConfiguration {


    @Bean("redisTemplate")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        RedisSerializer stringSerializer = new StringRedisSerializer(StandardCharsets.UTF_8);
        RedisSerializer genericFastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(genericFastJsonRedisSerializer);
        redisTemplate.setHashKeySerializer(genericFastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(genericFastJsonRedisSerializer);
        redisTemplate.setConnectionFactory(factory);

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }
}
