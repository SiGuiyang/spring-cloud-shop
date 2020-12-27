package quick.pager.shop.controller;

import com.google.common.collect.Maps;
import java.security.Principal;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String, Object> login(Principal principal, @RequestParam
            Map<String, String> parameters) {
        Map<String, Object> result = Maps.newHashMap();
        try {
            OAuth2AccessToken postAccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();


            result.put("data", Objects.nonNull(postAccessToken.getAdditionalInformation()) ? postAccessToken.getAdditionalInformation().get("profile") : null);
            result.put("code", 200);
            result.put("msg", "操作成功");
            result.put("access_token", postAccessToken.getValue());
            result.put("expiration", postAccessToken.getExpiration());
            result.put("expires_in", postAccessToken.getExpiresIn());
            result.put("token_type", postAccessToken.getTokenType());

            return result;
        } catch (HttpRequestMethodNotSupportedException e) {
            log.error("登录失败");
        }

        result.put("code", 1000);
        result.put("msg", "登录失败");
        return result;
    }

    @RequestMapping("/oauth/principal")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }
}
