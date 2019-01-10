package quick.pager.shop.manage.filter;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.common.utils.PermissionMap;

/**
 * 自定义权限过滤器，只针对访问资源
 *
 * @author siguiyang
 */
@Slf4j
public class PermissionFilter implements Filter {

    // 白名单权限
    private static final List<String> WHITE_LIST = Lists.newArrayList();

    static {
        WHITE_LIST.add("/admin/system/userInfo");
        WHITE_LIST.add("/admin/login");
        WHITE_LIST.add("/admin/system/role/classification");
        WHITE_LIST.add("/admin/upload");
        WHITE_LIST.add("/admin/download");
        WHITE_LIST.add("/admin/activity/coupon/template/enable");
        WHITE_LIST.add("/admin/publish/coupon");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();
        String sysCode = httpRequest.getParameter("sysCode");

        log.info("进入权限过滤器。。。");
        if (!WHITE_LIST.contains(requestURI)
                && !StringUtils.isEmpty(sysCode)
                && !PermissionMap.contains(sysCode, requestURI)) {
            log.info("您没有权限操作此功能。。。");
            httpResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            PrintWriter writer = httpResponse.getWriter();
            Response<String> noPermission = new Response<>();
            noPermission.setCode(ResponseStatus.Code.NO_PERMISSION);
            noPermission.setMsg(ResponseStatus.NO_PERMISSION);
            writer.append(JSON.toJSONString(noPermission));
            return;
        }

        chain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {
        PermissionMap.clear();
    }
}
