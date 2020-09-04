package quick.pager.shop.platform.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.platform.fallback.SystemConfigClientFallback;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.request.SystemConfigSaveRequest;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.user.response.Response;

/**
 * 暴露服务系统配置
 *
 * @author siguiyang
 * @version 3.0
 */
@FeignClient(value = ConstantsClient.PLATFORM_CLIENT, path = ConstantsClient.PLATFORM, fallbackFactory = SystemConfigClientFallback.class)
public interface SystemConfigClient {

    /**
     * 创建
     */
    @RequestMapping(value = "/config/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody SystemConfigSaveRequest request);

    /**
     * 创建配置
     */
    @RequestMapping(value = "/config/modify", method = RequestMethod.PUT)
    Response<Long> modify(@RequestBody SystemConfigSaveRequest request);

    /**
     * 查询配置列表，无分页
     */
    @RequestMapping(value = "/config/list", method = RequestMethod.GET)
    Response<List<SystemConfigResponse>> queryList(SystemConfigOtherRequest request);

    /**
     * 查询配置列表分页
     */
    @RequestMapping(value = "/config/page", method = RequestMethod.POST)
    Response<List<SystemConfigResponse>> queryPage(@RequestBody SystemConfigPageRequest request);
}
