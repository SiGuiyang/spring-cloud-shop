package quick.pager.shop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.risk.RiskDTO;
import quick.pager.shop.response.Response;

/**
 * 风控管理
 */
@RestController(value = Constants.Module.RISK)
public class RiskController {


    /**
     * 用户下单限制
     *
     * @param riskDTO 下单风控模型对象
     */
    @PostMapping("/order")
    public Response order(@RequestBody RiskDTO riskDTO) {
        return null;
    }
}
