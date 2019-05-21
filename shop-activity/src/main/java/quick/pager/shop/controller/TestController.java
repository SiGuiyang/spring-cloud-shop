package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {



    @Value("${demo.apollo.key:hello}")
    private String value;

    @GetMapping("/test/apollo")
    public String testApollo() {
        return value;
    }
}
