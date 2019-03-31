package quick.pager.shop.controller.dashboard;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
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

    @ApiOperation("首页周期统计数据")
    @PostMapping("/dashboard/cycle/statistics")
    public Response cycleStatistics(@RequestParam("event") String event) {
        BaseDTO dto = new BaseDTO();
        dto.setEvent(event);
        return dashboardService.doService(dto);
    }

    @ApiOperation("首页统计数据")
    @PostMapping("/dashboard/statistics")
    public Response statistics(BaseDTO dto) {
        return dashboardService.doService(dto);
    }
}
