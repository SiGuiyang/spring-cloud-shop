package quick.pager.shop.user.redis;

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
    private RedisTemplate<String,Serializable> redisTemplate;

    /**
     * set
     *
     * @param key   redis key
     * @param value 存储redis 的值
     * @param time  时间 秒
     */
    public void set(String key, Serializable value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * 设置hash 值
     *
     * @param key redis key
     */
    public void setFromHash(String key, Serializable value) {
        redisTemplate.opsForHash().put(key, key.hashCode(), value);
    }

    /**
     * 从hash 中获取
     *
     * @param key redis key
     */
    public <T extends Serializable> T getFromHash(String key) {
        return (T) redisTemplate.opsForHash().get(key, key.hashCode());
    }

    public void delFromHash(String key) {
        redisTemplate.opsForHash().delete(key, key.hashCode());
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
     * del 删除
     *
     * @param key redis key
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }

}
