package quick.pager.shop.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import quick.pager.shop.model.SystemConfig;

/**
 * 系统配置缓存
 */
public class SystemConfigMap {

    // 系统配置t_system_config配置缓存
    private static final Map<String, List<SystemConfig>> CACHE = new ConcurrentHashMap<>();


    /**
     * 添加到JVM 中
     *
     * @param key   标识 key
     * @param value 存储的值 value
     */
    public static void put(String key, List<SystemConfig> value) {
        getCache().put(key, value);
    }

    /**
     * 添加所有
     */
    public static void putAllSystemConfig(Map<String, List<SystemConfig>> data) {
        getCache().putAll(data);
    }

    /**
     * 从JVM中获取值
     *
     * @param key 标识 key
     */
    public static List<SystemConfig> get(String key) {
        return getCache().get(key);
    }


    public static Map<String, List<SystemConfig>> getCache() {
        return SystemConfigMap.CACHE;
    }
}
