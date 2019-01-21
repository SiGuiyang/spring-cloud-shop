package quick.pager.shop.zuul;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/list")
    public void list() {
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        List<ServiceInstance> instances = discoveryClient.getInstances("shop-user");

        instances.forEach(inst -> {
            System.out.println(inst.getHost());
            System.out.println(inst.getPort());
            System.out.println(inst.getServiceId());
            System.out.println(inst.getUri());
        });

    }
}
