package quick.pager.shop.security;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import quick.pager.shop.resp.Response;

/**
 * 重写LoginUrlAuthenticationEntryPoint#commence异常处理
 *
 * @author siguiyang
 */
public class ShopLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    /**
     * @param loginFormUrl URL where the login page can be found. Should either be
     *                     relative to the web-app context path (include a leading {@code /}) or an absolute
     *                     URL.
     */
    public ShopLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        // redirect to login page. Use https if forceHttps true
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();

        Throwable cause = authException.getCause();

        Response<String> resp = new Response<>();

        if (cause instanceof InsufficientAuthenticationException) {
            resp.setCode(201);
            resp.setMsg("未登陆");
        } else if (cause instanceof UsernameNotFoundException) {
            resp.setCode(202);
            resp.setMsg("用户名不存在");
        } else if (cause instanceof BadCredentialsException) {
            resp.setCode(203);
            resp.setMsg("密码不正确");
        } else if (cause instanceof InvalidTokenException) {
            resp.setCode(204);
            resp.setMsg("登陆过期");
        } else {
            resp.setCode(205);
            resp.setMsg("未知异常");
        }

        response.setStatus(200);
        out.write(new ObjectMapper().writeValueAsString(resp));
        out.flush();
        out.close();
    }
}
