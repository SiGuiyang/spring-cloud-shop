package quick.pager.shop.risk.client.job;

import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;

/**
 * 测试定时任务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.RISK_CLIENT, path = ConstantsClient.RISK)
public interface RiskTestJobClient {

    @RequestMapping(value = "/test/job/execute", method = RequestMethod.POST)
    Map<String, Object> execute(@RequestBody String params);
}
