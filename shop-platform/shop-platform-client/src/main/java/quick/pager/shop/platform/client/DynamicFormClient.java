package quick.pager.shop.platform.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.platform.fallback.DynamicFormClientFallback;
import quick.pager.shop.platform.request.DynamicFormSaveRequest;
import quick.pager.shop.platform.response.DynamicFormResponse;
import quick.pager.shop.user.response.Response;

/**
 * feignClient 对外服务
 *
 * @author siguiyang
 * @version 3.0
 */
@FeignClient(value = ConstantsClient.PLATFORM_CLIENT, path = ConstantsClient.PLATFORM, fallbackFactory = DynamicFormClientFallback.class)
public interface DynamicFormClient {

    /**
     * 新增
     */
    @RequestMapping(value = "/dynamic/form/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody DynamicFormSaveRequest request);

    /**
     * 修改
     */
    @RequestMapping(value = "/dynamic/form/modify", method = RequestMethod.POST)
    Response<Long> modify(@RequestBody DynamicFormSaveRequest request);

    /**
     * 根据bizType 获取表单模型
     */
    @RequestMapping(value = "/dynamic/form/get", method = RequestMethod.GET)
    Response<List<DynamicFormResponse>> get(@RequestParam("bizType") String bizType);
}
