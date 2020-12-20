package quick.pager.shop.risk.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.risk.fallback.RiskClientFallbackFactory;
import quick.pager.shop.risk.request.WhiteBlacklistPageRequest;
import quick.pager.shop.risk.request.WhiteBlacklistSaveRequest;
import quick.pager.shop.user.response.Response;

/**
 * 风控服务
 *
 * @author siguiyang
 * @version 3.0
 */
@FeignClient(value = ConstantsClient.RISK_CLIENT, path = ConstantsClient.RISK, fallbackFactory = RiskClientFallbackFactory.class)
public interface RiskClient {


    /**
     * 黑名单列表
     *
     * @param request 请求参数
     * @return 黑名单列表
     */
    @PostMapping(value = "/blackList/list")
    Response queryList(@RequestBody WhiteBlacklistPageRequest request);

    /**
     * 新增黑名单
     *
     * @param request 请求参数
     * @return 黑名单主键
     */
    @PostMapping(value = "/create")
    Response<Long> create(@RequestBody WhiteBlacklistSaveRequest request);

    /**
     * 修改
     *
     * @param request 请求参数
     * @return 黑名单主键
     */
    @PutMapping(value = "/modify")
    Response<Long> modify(@RequestBody WhiteBlacklistSaveRequest request);

    /**
     * 删除黑名单
     *
     * @param id 黑名单主键
     * @return 黑名单主键
     */
    @DeleteMapping(value = "/{id}/delete")
    Response<Long> delete(@PathVariable("id") Long id);
}
