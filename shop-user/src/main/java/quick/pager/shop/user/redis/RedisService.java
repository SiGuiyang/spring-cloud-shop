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
    private RedisTemplate redisTemplate;

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

    public void setValueOps(String key, Serializable value, long time) {
        redisTemplate.boundValueOps(key).set(value, time, TimeUnit.SECONDS);
    }

    public Object getValueOps(String key) {
        return redisTemplate.boundValueOps(key).get();
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
