package quick.pager.shop.utils;

import com.alibaba.fastjson.JSON;
import java.nio.charset.Charset;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import quick.pager.shop.response.Response;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 响应工具类
 *
 * @author siguiyang
 */
public class ResponseUtils {

    /**
     * 响应结果
     */
    public static Mono<Void> toResponse(ServerWebExchange exchange, HttpStatus httpStatus, int code, String msg) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);

        Response<String> noPermission = new Response<>();
        noPermission.setCode(code);
        noPermission.setMsg(msg);
        DataBuffer buffer = response.bufferFactory()
                .wrap(JSON.toJSONString(noPermission).getBytes(Charset.forName("UTF-8")));
        return response.writeWith(Flux.just(buffer));
    }
}
