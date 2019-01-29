package quick.pager.shop.activity.controller.client;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.activity.service.client.BannerClientService;
import quick.pager.shop.feign.dto.BannerDTO;

/**
 * 暴露给系统后台的服务
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
public class BannerClientController {

    @Autowired
    private BannerClientService bannerClientService;

    @ApiOperation("banner 列表")
    @PostMapping("/banner/fetch")
    public Response fetch(@RequestBody BannerDTO bannerDTO) {
        return bannerClientService.doService(bannerDTO);
    }

    @ApiOperation("banner 新增|修改|")
    @PostMapping("/banner/modify")
    public Response modify(@RequestBody BannerDTO bannerDTO) {

        return bannerClientService.doService(bannerDTO);
    }
}
