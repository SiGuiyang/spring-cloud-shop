package quick.pager.shop.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 获取当前登录用户信息
 *
 * @author Siguiyang
 */
public class AuthUtils {

    public static Authentication getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
