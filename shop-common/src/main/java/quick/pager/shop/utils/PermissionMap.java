package quick.pager.shop.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 权限缓存
 *
 * @author siguiyang
 */
public class PermissionMap {

    private static final Map<String, List<String>> PERMISSION = new ConcurrentHashMap<>();

    public static void put(String key, List<String> value) {
        getPermission().put(key, value);
    }

    public static List<String> get(String key) {
        return getPermission().get(key);
    }

    public static boolean contains(String sysCode, String value) {
        return getPermission().get(sysCode).contains(value);
    }

    private static Map<String, List<String>> getPermission() {
        return PermissionMap.PERMISSION;
    }


    public static void clear() {
        getPermission().clear();
    }
}
