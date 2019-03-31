package quick.pager.shop.filter;

import com.alibaba.fastjson.JSON;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import quick.pager.shop.constants.RedisKeys;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.utils.ResponseUtils;
import reactor.core.publisher.Mono;

/**
 * 管理后台权限处理 <br />
 * 所有请求都基于表单式post提交 <br />
 *
 * @author siguiyang
 */
@Slf4j
public class PermissionFilter implements GatewayFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        RedisService redisService = exchange.getApplicationContext().getBean(RedisService.class);

        ServerHttpRequest request = exchange.getRequest();
        String methodValue = request.getMethodValue();
        String requestURI = request.getPath().value();

        log.info("请求地址 url = {}, 请求方法 method = {}", requestURI, methodValue);
        MultiValueMap<String, String> params = request.getQueryParams();

        String sysCode = params.getFirst("sysCode");

        List<String> whiteLists = JSON.parseArray(redisService.get(RedisKeys.CommonKeys.REQUEST_URL_WHITE_LIST), String.class);

        // 校验URL是否有权限
        // 不在白名单，并且登陆状态，没有访问权限资源进入
        if (!whiteLists.contains(requestURI)
                && !StringUtils.isEmpty(sysCode)
                && !redisService.contains(sysCode, requestURI)) {
            log.info("您没有权限操作此功能。。。");

            return ResponseUtils.toResponse(exchange, HttpStatus.UNAUTHORIZED, ResponseStatus.Code.NO_PERMISSION, ResponseStatus.NO_PERMISSION);

        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

}
