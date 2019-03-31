package quick.pager.shop.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 系统变量存储与JVM 缓存
 *
 * @author siguiyang
 */
public class SysConfigMap {

    private static final Map<String, String> CACHE = new ConcurrentHashMap<>();

    /**
     * 添加到JVM 中
     *
     * @param key   标识 key
     * @param value 存储的值 value
     */
    public static void put(String key, String value) {
        getCache().put(key, value);
    }


    /**
     * 从JVM中获取值
     *
     * @param key 标识 key
     */
    public static String get(String key) {
        return getCache().get(key);
    }


    public static Map<String, String> getCache() {
        return SysConfigMap.CACHE;
    }

}
