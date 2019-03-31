package quick.pager.shop.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import quick.pager.shop.resp.Response;

/**
 * 重写SimpleUrlAuthenticationSuccessHandler#onAuthenticationSuccess 登陆成功后的返回
 *
 * @author siguiyang
 */
public class ShopAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        if (MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType())
                || MediaType.APPLICATION_JSON_UTF8_VALUE.equals(request.getContentType())) {

            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().println(new ObjectMapper().writeValueAsString(new Response<>()));
            response.getWriter().flush();
            this.clearAuthenticationAttributes(request);
        } else {

            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
