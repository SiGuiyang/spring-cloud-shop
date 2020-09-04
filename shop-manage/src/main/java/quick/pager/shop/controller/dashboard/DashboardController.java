package quick.pager.shop.controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.dashboard.DashboardService;

/**
 * 首页统计数据
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    /**
     * 首页周期统计数据
     */
    @PostMapping("/dashboard/cycle/statistics")
    public Response cycleStatistics(@RequestParam("event") String event) {

        return null;
    }

    /**
     * 首页统计数据
     */
    @PostMapping("/dashboard/statistics")
    public Response statistics() {
        return null;
    }
}
