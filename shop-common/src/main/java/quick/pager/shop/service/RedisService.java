package quick.pager.shop.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.concurrent.TimeUnit;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.configuration.ShopRedisTemplate;

/**
 * 缓存服务
 *
 * @author siguiyang
 */
public class RedisService {

    private ShopRedisTemplate shopRedisTemplate;

    public RedisService(ShopRedisTemplate shopRedisTemplate) {
        this.shopRedisTemplate = shopRedisTemplate;
    }

    /**
     * set
     *
     * @param key   redis key
     * @param value 存储redis 的值
     * @param time  时间 秒
     */
    public void set(String key, Serializable value, long time) {
        shopRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * get
     *
     * @param key redis key
     */
    public <T extends Serializable> T get(String key) {
        return (T) shopRedisTemplate.opsForValue().get(key);
    }


    /**
     * del 删除
     *
     * @param key redis key
     */
    public void del(String key) {
        shopRedisTemplate.delete(key);
    }


    public void setValueOps(String key, String value, long time) {
        shopRedisTemplate.boundValueOps(key).set(value, time, TimeUnit.SECONDS);
    }

    public Serializable getValueOps(String key) {
        return shopRedisTemplate.boundValueOps(key).get();
    }

    /**
     * redis hash 处理
     * 取值 map
     *
     * @param key key
     * @return map
     */
    public Map<Object, Object> getMapOps(String key) {
        return shopRedisTemplate.boundHashOps(key).entries();
    }

    /**
     * redis hash 处理
     * 设值
     *
     * @param key   key
     * @param value value map
     */
    public void setMapOps(String key, Map value) {
        shopRedisTemplate.boundHashOps(key).putAll(value);
    }


    /**
     * redis list 处理
     *
     * @param key  key
     * @param data 缓存数组数据
     */
    public void setListOps(String key, ArrayList<?> data) {
        shopRedisTemplate.opsForList().leftPushAll(key, data);
    }

    /**
     * 从redis 中获取list数据
     *
     * @param key redis key
     */
    public List getListOps(String key) {
        return (List) shopRedisTemplate.opsForList().rightPop(key);
    }

    /**
     * 模糊查询key
     *
     * @param key redis key
     */
    public Set<String> keys(String key) {
        return shopRedisTemplate.keys(key + "*");
    }

    /**
     * 批量删除key
     *
     * @param keys keys 集合
     */
    public void batchDel(Set<String> keys) {
        if (!CollectionUtils.isEmpty(keys)) {
            keys.forEach(this::del);
        }
    }

    /**
     * 从hash 中查询是否存在这个值
     *
     * @param key   key
     * @param value 存在hash 中的value
     */
    public boolean contains(String key, String value) {
        return this.getMapOps(key).containsValue(value);
    }

}
