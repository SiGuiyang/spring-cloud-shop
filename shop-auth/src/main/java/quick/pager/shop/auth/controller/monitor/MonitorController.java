package quick.pager.shop.auth.controller.monitor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;

@Api(description = "监控服务")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class MonitorController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @ApiOperation("获取serviceUrl服务地址")
    @PostMapping("/monitor/serviceUrl")
    public Response<String> serviceUrl(@RequestParam("serviceId") String serviceId) {

        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        // 服务地址
        if (CollectionUtils.isEmpty(instances)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.SERVICE_NOT_FOUND);
        }

        ServiceInstance serviceInstance = instances.get(0);

        Response<String> response = new Response<>();

        response.setData(serviceInstance.getUri().toString());
        return response;
    }
}
