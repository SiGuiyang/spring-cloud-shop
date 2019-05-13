package quick.pager.shop.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.BlackListDTO;
import quick.pager.shop.fallback.RiskClientFallbackFactory;
import quick.pager.shop.response.Response;

@FeignClient(value = "shop-risk", path = Constants.Module.RISK, fallbackFactory = RiskClientFallbackFactory.class)
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
    @DeleteMapping(value = "/blackList/{id}")
    Response delBlackLists(@PathVariable("id") Long id);
}
