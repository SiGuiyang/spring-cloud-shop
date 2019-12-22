package quick.pager.shop.risk.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.risk.fallback.RiskClientFallbackFactory;
import quick.pager.shop.response.Response;
import quick.pager.shop.risk.request.BlackListPageRequest;
import quick.pager.shop.risk.request.BlackListSaveRequest;

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
    Response getBlackLists(@RequestBody BlackListPageRequest request);

    /**
     * 新增
     */
    @PostMapping(value = "/blackList")
    Response addBlackLists(@RequestBody BlackListSaveRequest request);

    /**
     * 修改
     */
    @PutMapping(value = "/blackList")
    Response modifyBlackLists(@RequestBody BlackListSaveRequest request);

    /**
     * 删除
     */
    @DeleteMapping(value = "/{id}/blackList")
    Response delBlackLists(@PathVariable("id") Long id);
}
