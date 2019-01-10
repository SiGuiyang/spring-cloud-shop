package quick.pager.shop.user.handler;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import quick.pager.common.annotation.Login;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.shop.user.redis.RedisService;

/**
 * 是否需要登陆才能访问的拦截器
 *
 * @author siguiyang
 */
@Component
public class LoginHandlerInterceptors extends HandlerInterceptorAdapter {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            Method method = hm.getMethod();

            // 需要登陆的方法
            if (method.isAnnotationPresent(Login.class)) {
                String token = request.getParameter("token");
                String userId = "";
                userId = request.getParameter("userId");
                // 如果请求域中没有userId入参，则检测restful 风控中是否存在userId
                if (StringUtils.isEmpty(userId)) {
                    NativeWebRequest webRequest = new ServletWebRequest(request);
                    LinkedHashMap map = (LinkedHashMap) webRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
                    if (!CollectionUtils.isEmpty(map)) {
                        userId = (String) map.get("userId");
                    }
                }

                String tokenFromRedis = String.valueOf(redisService.getValueOps(userId));
                // redis 中没有用户登陆的token ，则未登陆
                if (StringUtils.isEmpty(token) || StringUtils.isEmpty(tokenFromRedis)) {

                    writeResponse(response);
                    return false;
                }

                // token 不一致, 则token失效
                if (!token.equalsIgnoreCase(tokenFromRedis)) {
                    writeResponse(response);
                    return false;
                }
            }
        }
        return super.preHandle(request, response, handler);
    }

    /**
     * 返回客户端结果
     */
    private void writeResponse(HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter writer = response.getWriter();
        Response<String> noPermission = new Response<>();
        noPermission.setCode(ResponseStatus.Code.LOGIN_EXPIRE);
        noPermission.setMsg(ResponseStatus.LOGIN_EXPIRE);
        writer.append(JSON.toJSONString(noPermission));
        writer.close();
    }


}
