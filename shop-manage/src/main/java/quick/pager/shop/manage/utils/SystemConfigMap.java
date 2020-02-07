package quick.pager.shop.manage.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import quick.pager.shop.platform.response.SystemConfigResponse;

/**
 * 系统配置缓存
 *
 * @author siguiyang
 * @version 3.0
 */
public class SystemConfigMap {

    /**
     * 系统配置t_system_config配置缓存
     */
    private static final Map<String, List<SystemConfigResponse>> CACHE = new ConcurrentHashMap<>();


    /**
     * 添加到JVM 中
     *
     * @param key   标识 key
     * @param value 存储的值 value
     */
    public static void put(String key, List<SystemConfigResponse> value) {
        getCache().put(key, value);
    }

    /**
     * 添加所有
     */
    public static void putAllSystemConfig(Map<String, List<SystemConfigResponse>> data) {
        getCache().putAll(data);
    }

    /**
     * 从JVM中获取值
     *
     * @param key 标识 key
     */
    public static List<SystemConfigResponse> get(String key) {
        return getCache().get(key);
    }


    public static Map<String, List<SystemConfigResponse>> getCache() {
        return SystemConfigMap.CACHE;
    }
}
