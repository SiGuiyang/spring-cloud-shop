package quick.pager.shop.platform.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;
import quick.pager.shop.platform.client.SystemConfigClient;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.request.SystemConfigSaveRequest;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.response.Response;

/**
 * 系统配置熔断
 *
 * @author siguiyang
 * @version 3.0
 */
@Component
public class SystemConfigClientFallback implements FallbackFactory<SystemConfigClient> {
    @Override
    public SystemConfigClient create(Throwable cause) {
        return new SystemConfigClient() {
            @Override
            public Response<Long> create(SystemConfigSaveRequest request) {
                return null;
            }

            @Override
            public Response<Long> modify(SystemConfigSaveRequest request) {
                return null;
            }

            @Override
            public Response<List<SystemConfigResponse>> queryList(SystemConfigOtherRequest request) {
                return new Response<>();
            }

            @Override
            public Response<List<SystemConfigResponse>> queryPage(SystemConfigPageRequest request) {
                return null;
            }
        };
    }
}
