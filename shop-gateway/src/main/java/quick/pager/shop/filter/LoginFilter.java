package quick.pager.shop.filter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import quick.pager.shop.utils.WebUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * APP是否登陆
 * 拦截过滤器
 *
 * @author siguiyang
 */
public class LoginFilter implements GatewayFilter, Ordered {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        // Seller APP 登陆时的token
        String token = WebUtils.getParameter(request, "token");
        // 获取用户Id
        String userId = WebUtils.getParameter(request, "userId");

        // post 请求，从requestBody获取参数
        if (HttpMethod.POST.equals(exchange.getRequest().getMethod())) {
            String result = WebUtils.resolveBodyFromRequest(exchange.getRequest());
            Gson gson = new GsonBuilder().create();
            Map map = gson.fromJson(result, Map.class);
            if (StringUtils.isEmpty(userId)) {
                userId = String.valueOf(map.get("userId"));
            }
            if (StringUtils.isEmpty(token)) {
                token = String.valueOf(map.get("token"));
            }
        }

        // 获取redis中的token
        String redisToken = String.valueOf(redisTemplate.boundValueOps(userId).get());

        ServerHttpResponse response = exchange.getResponse();

        // token 为空，userId为空，redisToken为空，token 为 "null"，userId 为 "null"，token与redisToken不相等
        // 这几种情况都是未登陆的，拦截处理
        if (StringUtils.isEmpty(token)
                || "null".equals(token)
                || StringUtils.isEmpty(userId)
                || "null".equals(userId)
                || StringUtils.isEmpty(redisToken)
                || "null".equals(redisToken)
                || !token.equals(redisToken)) {
            response.setStatusCode(HttpStatus.OK);
            String result = "{\"msg\":\"none login\",\"code\":4000}";
            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(result.getBytes(StandardCharsets.UTF_8));
            return exchange.getResponse().writeWith(Flux.just(buffer));
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -2;
    }

}
