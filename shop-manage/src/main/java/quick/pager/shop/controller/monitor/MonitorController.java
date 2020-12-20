package quick.pager.shop.controller.monitor;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;

/**
 * 监控服务
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class MonitorController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取serviceUrl服务地址
     */
    @PostMapping("/monitor/serviceUrl")
    public Response<String> serviceUrl(@RequestParam("serviceId") String serviceId) {

        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        Assert.isTrue(CollectionUtils.isNotEmpty(instances), () -> ResponseStatus.SERVICE_NOT_FOUND);
        // 服务地址
        ServiceInstance serviceInstance = instances.get(0);

        Response<String> response = Response.toResponse();

        response.setData(serviceInstance.getUri().toString());
        return response;
    }
}
