package quick.pager.shop.utils;

import java.nio.charset.StandardCharsets;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * gateway 工具类
 *
 * @author siguiyang
 */
public class WebUtils {

    /**
     * 获取请求体中的字符串内容
     */
    public static String resolveBodyFromRequest(ServerHttpRequest request) {
        StringBuilder sb = new StringBuilder();

        request.getBody().subscribe(buffer -> {
            buffer.asInputStream();
            byte[] bytes = new byte[buffer.readableByteCount()];
            buffer.read(bytes);
            DataBufferUtils.release(buffer);
            String bodyString = new String(bytes, StandardCharsets.UTF_8);
            sb.append(bodyString);
        });

        return sb.toString();
    }

    /**
     * 获取请求参数
     *
     * @param request request 请求对象
     * @param key     请求参数的key
     * @return 参数内容
     */
    public static String getParameter(ServerHttpRequest request, String key) {
        return request.getQueryParams().getFirst(key);
    }

    /**
     * 获取请求参数
     *
     * @param request request 请求对象
     * @param key     请求参数的key
     * @return 参数内容
     */
    public static String getHeader(ServerHttpRequest request, String key) {
        return request.getHeaders().getFirst(key);
    }
}
