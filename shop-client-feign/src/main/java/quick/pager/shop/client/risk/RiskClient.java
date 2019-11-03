package quick.pager.shop.client.risk;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.dto.risk.BlackListDTO;
import quick.pager.shop.fallback.risk.RiskClientFallbackFactory;
import quick.pager.shop.response.Response;

/**
 * 风控服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.RISK_CLIENT, path = ConstantsClient.RISK, fallbackFactory = RiskClientFallbackFactory.class)
public interface RiskClient {


    /**
     * 列表
     */
    @PostMapping(value = "/blackList/list")
    Response getBlackLists(@RequestBody BlackListDTO dto);

    /**
     * 新增
     */
    @PostMapping(value = "/blackList")
    Response addBlackLists(@RequestBody BlackListDTO dto);

    /**
     * 修改
     */
    @PutMapping(value = "/blackList")
    Response modifyBlackLists(@RequestBody BlackListDTO dto);

    /**
     * 删除
     */
    @DeleteMapping(value = "/{id}/blackList")
    Response delBlackLists(@PathVariable("id") Long id);
}
