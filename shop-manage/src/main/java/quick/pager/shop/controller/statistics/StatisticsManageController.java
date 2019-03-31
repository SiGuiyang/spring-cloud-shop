package quick.pager.shop.controller.statistics;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;

/**
 * 统计管理
 *
 * @author siguiyang
 */
@Api(description = "统计管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class StatisticsManageController {
    @ApiOperation("优惠券统计")
    @PostMapping("/statistics/coupon")
    public Response coupon() {
        return null;
    }

    @ApiOperation("拼团统计")
    @PostMapping("/statistics/fightGroup")
    public Response fightGroup() {
        return null;
    }

    @ApiOperation("积分统计")
    @PostMapping("/statistics/integral")
    public Response integral() {
        return null;
    }
}
