package quick.pager.shop.manage.controller.statistics;

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
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class StatisticsManageController {
    /**
     * 优惠券统计
     */
    @PostMapping("/statistics/coupon")
    public Response coupon() {
        return null;
    }

    /**
     * 拼团统计
     */
    @PostMapping("/statistics/fightGroup")
    public Response fightGroup() {
        return null;
    }

    /**
     * 积分统计
     */
    @PostMapping("/statistics/integral")
    public Response integral() {
        return null;
    }
}
