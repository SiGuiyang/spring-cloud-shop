package quick.pager.shop.platform.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.platform.fallback.SystemConfigClientFallback;
import quick.pager.shop.platform.request.SystemConfigDetailOtherRequest;
import quick.pager.shop.platform.response.SystemConfigDetailResponse;
import quick.pager.shop.user.response.Response;

/**
 * 配置详情
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.PLATFORM_CLIENT, path = ConstantsClient.PLATFORM, fallbackFactory = SystemConfigClientFallback.class)
public interface SystemConfigDetailClient {

    /**
     * 获取配置明细列表
     *
     * @param request 请求参数
     */
    @RequestMapping(value = "/config/detail/list", method = RequestMethod.GET)
    Response<List<SystemConfigDetailResponse>> queryList(SystemConfigDetailOtherRequest request);
}
