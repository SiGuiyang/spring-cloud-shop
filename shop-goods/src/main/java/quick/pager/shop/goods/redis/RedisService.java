package quick.pager.shop.goods.redis;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * 缓存服务
 *
 * @author siguiyang
 */
@Component
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * set
     *
     * @param key   redis key
     * @param value redis value
     * @param time  过期时间
     */
    public void set(String key, Serializable value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * 模糊查询key
     *
     * @param key redis key
     */
    public Set<String> keys(String key) {
        return stringRedisTemplate.keys(key + "*");
    }

    /**
     * get
     *
     * @param key redis key
     */
    public <T extends Serializable> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }


    /**
     * del
     *
     * @param key redis key
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除key
     *
     * @param keys keys 集合
     */
    public void batchDel(Set<String> keys) {
        if (!CollectionUtils.isEmpty(keys)) {
            keys.forEach(key -> this.del(key));
        }
    }

}
