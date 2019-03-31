package quick.pager.shop.controller.activity;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.dto.BannerDTO;

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
    public Response list(BannerDTO dto) {
        return activityClient.fetch(dto);
    }

    @ApiOperation("banner 新增|修改|")
    @PostMapping("/activity/banner/modify")
    public Response modify(BannerDTO dto) {
        return activityClient.modify(dto);
    }

}
