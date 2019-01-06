package quick.pager.shop.manage.controller.finance;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;

@Api(description = "财务管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class FinanceController {

    @ApiOperation("资金管理")
    @PostMapping("/finance/fund")
    public Response fund () {
        return null;
    }

    @ApiOperation("交易管理")
    @PostMapping("/finance/trade")
    public Response trade () {
        return null;
    }
}
