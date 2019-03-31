package quick.pager.shop.fallback;

import com.alibaba.fastjson.JSON;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * shop fallback
 *
 * @author siguiyang
 */
@Component
@Slf4j
public class ShopFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            @NonNull
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            @NonNull
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            @NonNull
            public InputStream getBody() throws IOException {
                log.error("网关服务转发异常，进入熔断措施 route = {}", route);
                Map<String, Object> result = new ConcurrentHashMap<>();
                result.put("code", 1000);
                result.put("msg", "网络发生点故障，请稍后重试");
                return new ByteArrayInputStream(JSON.toJSONString(result).getBytes(Charset.forName("UTF-8")));
            }

            @Override
            @NonNull
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8); //设置头
                return headers;
            }
        };
    }
}
