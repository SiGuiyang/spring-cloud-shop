package quick.pager.shop.goods.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * 缓存服务
 *
 * @author siguiyang
 */
@Component
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * set
     * @param key
     * @param value
     * @param time
     */
    public void set(String key, Serializable value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * get
     * @param key
     * @param <T>
     * @return
     */
    public <T extends Serializable> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }


    /**
     * del
     * @param key
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }
    
}
