package quick.pager.shop.controller.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.service.BannerService;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

/**
 * app banner列表
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class AppBannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * app 首页banner 列表
     *
     * @param userId 用户主键
     * @param lat    纬度
     * @param lng    经度
     * @return
     */
    @GetMapping("/app/user/banners")
    public Response<List<BannerResponse>> banners(@RequestParam(value = "userId", required = false) Long userId,
                                                  @RequestParam(value = "lat", required = false) String lat,
                                                  @RequestParam(value = "lng", required = false) String lng) {

        return bannerService.banners(userId, lat, lng);
    }

    /**
     * 首页banner分享渠道
     *
     * @param id banner 主键
     * @return
     */
    @GetMapping("/app/user/banners/channel/{id}")
    public Response channel(@PathVariable("id") Long id) {

        return bannerService.channel(id);
    }
}
