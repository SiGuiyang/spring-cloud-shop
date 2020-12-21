package quick.pager.shop.controller;

import java.security.Principal;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import quick.pager.shop.model.LoginUser;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;

/**
 * 权限验证授权
 *
 * @author siguiyang
 */
@RestController
@Slf4j
public class AuthController {

    @Resource
    private TokenEndpoint tokenEndpoint;

    /**
     * 自定义授权
     *
     * @param principal  鉴权auth
     * @param parameters 请求参数
     */
    @RequestMapping("/oauth/token")
    public Response<Object> login(Principal principal, @RequestParam
            Map<String, String> parameters) {
        try {
            OAuth2AccessToken postAccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();

            Assert.isTrue(Objects.nonNull(postAccessToken), () -> "授权登录失败");

            return Response.toResponse(postAccessToken.getAdditionalInformation().get("profile"));
        } catch (HttpRequestMethodNotSupportedException e) {
            log.error("登录失败");
        }

        return Response.toError("登录失败");
    }

    @RequestMapping("/oauth/principal")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }
}
