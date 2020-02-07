package quick.pager.shop.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.response.Response;
import quick.pager.shop.user.service.BannerService;

/**
 * 消费者端 banner
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.USER)
public class UserBannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * Banner 列表
     */
    @PostMapping("/banner/list")
    public Response<List<BannerResponse>> list() {
        return bannerService.queryList();
    }
}
