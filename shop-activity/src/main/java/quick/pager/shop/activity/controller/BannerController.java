package quick.pager.shop.activity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.response.Response;
import quick.pager.shop.activity.service.BannerService;

/**
 * banner
 */
@RestController
@Api(description = "banner接口")
public class BannerController {


    @Autowired
    private BannerService bannerService;

    @PostMapping("/activity/banners")
    @ApiOperation("客户端banner列表")
    public Response banners() {
        return bannerService.doService(null);
    }
}
