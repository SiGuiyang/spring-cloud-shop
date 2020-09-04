package quick.pager.shop.controller;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;

/**
 * job任务测试
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.RISK)
public class RiskTestJobController {


    @RequestMapping(value = "/test/job/execute", method = RequestMethod.POST)
    public Map<String, Object> execute(@RequestBody String params) {

        System.out.println("执行风控测试任务" + params);
        return ImmutableMap.of("code", 200, "msg", "执行成功");
    }
}
