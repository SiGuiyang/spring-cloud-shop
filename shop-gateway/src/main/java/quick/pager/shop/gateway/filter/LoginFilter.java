package quick.pager.shop.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.service.RedisService;
import quick.pager.shop.gateway.utils.ResponseUtils;
import reactor.core.publisher.Mono;

/**
 * 面向用户登陆处理 <br />
 * 所有请求都基于表单式post提交 <br />
 *
 * @author siguiyang
 */
@Slf4j
@Component
public class LoginFilter implements GatewayFilter, Ordered {


    @Autowired
    private RedisService redisService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        // 非管理后台以下逻辑
        String token = request.getQueryParams().getFirst("token");
        String userId = request.getQueryParams().getFirst("userId");


        String tokenFromRedis = String.valueOf(redisService.getValueOps(userId));
        // redis 中没有用户登陆的token ，则未登陆
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(tokenFromRedis)) {
            log.info("未登陆");
            return ResponseUtils.toResponse(exchange, HttpStatus.UNAUTHORIZED, ResponseStatus.Code.LOGIN_EXPIRE, ResponseStatus.LOGIN_EXPIRE);
        }

        // token 不一致, 则token失效
        if (!token.equalsIgnoreCase(tokenFromRedis)) {
            log.info("多端登陆，token失效");
            return ResponseUtils.toResponse(exchange, HttpStatus.UNAUTHORIZED, ResponseStatus.Code.LOGIN_EXPIRE, ResponseStatus.LOGIN_EXPIRE);

        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -2;
    }
}
