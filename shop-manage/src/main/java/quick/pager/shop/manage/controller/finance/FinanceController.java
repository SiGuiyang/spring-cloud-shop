package quick.pager.shop.manage.controller.finance;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;

/**
 * 财务管理
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class FinanceController {
    /**
     * 资金管理
     */
    @PreAuthorize("hasAuthority('PAGER_FINANCE_FUND')")
    @PostMapping("/finance/fund")
    public Response fund() {
        return null;
    }

    /**
     * 交易管理
     */
    @PreAuthorize("hasAuthority('PAGER_FINANCE_TRADE')")
    @PostMapping("/finance/trade")
    public Response trade() {
        return null;
    }
}
