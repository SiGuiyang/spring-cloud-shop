package quick.pager.shop.manage.controller.activity;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.client.ActivityClient;
import quick.pager.shop.model.feign.request.BannerRequest;

/**
 * banner 管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class BannerManageController {

    @Autowired
    private ActivityClient activityClient;

    @HystrixCommand
    @ApiOperation("banner 列表")
    @PostMapping("/activity/banner/list")
    public Response list(BannerRequest request) {
        return activityClient.fetch(request);
    }

    @ApiOperation("banner 新增|修改|")
    @PostMapping("/activity/banner/modify")
    public Response modify(BannerRequest request) {
        return activityClient.modify(request);
    }

}
