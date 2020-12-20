package quick.pager.shop.utils;


import java.util.function.Supplier;
import org.springframework.lang.Nullable;
import quick.pager.shop.exception.ShopException;

/**
 * 断言
 *
 * @author siguiyang
 */
public class Assert {

    /**
     * 通用处理对外抛异常，用系统统一异常管理机制
     *
     * @param expression      true 正常，false 异常，需要对外抛出异常
     * @param messageSupplier 异常消息
     */
    public static void isTrue(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new ShopException(nullSafeGet(messageSupplier));
        }
    }

    private static String nullSafeGet(Supplier<String> messageSupplier) {
        return (messageSupplier != null ? messageSupplier.get() : null);
    }
}
