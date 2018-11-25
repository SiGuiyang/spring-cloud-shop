package quick.pager.shop.settlement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.response.Response;
import quick.pager.shop.settlement.service.SettlementService;

/**
 * 订单清结算
 *
 * @author siguiyang
 */
@RestController
public class SettlementController {

    @Autowired
    private SettlementService settlementService;

    /**
     * 清结算
     *
     * @param orderId 订单Id
     */
    @RequestMapping("/settlement/{orderId}")
    public Response settlement(@PathVariable("orderId") Long orderId) {
        return null;
    }

}
