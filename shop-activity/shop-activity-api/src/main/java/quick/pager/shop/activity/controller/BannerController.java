package quick.pager.shop.activity.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.model.Banner;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.activity.request.banner.BannerSaveRequest;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.BannerService;
import quick.pager.shop.utils.BeanCopier;

/**
 * banner管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping(value = "/banner/queryByPk")
    public Response<BannerResponse> queryByPk(@RequestParam("id") Long id) {
        Banner banner = bannerService.getById(id);
        return new Response<>(BeanCopier.create(banner, new BannerResponse()).copy());
    }

    /**
     * banner 列表
     */
    @PostMapping("/banner/list")
    public Response<List<BannerResponse>> queryList(@RequestBody BannerOtherRequest request) {
        return bannerService.queryList(request);
    }

    /**
     * banner 列表
     */
    @PostMapping("/banner/page")
    public Response<List<BannerResponse>> queryPage(@RequestBody BannerPageRequest request) {
        return bannerService.queryPage(request);
    }

    /**
     * banner 新增
     */
    @PostMapping("/banner/create")
    public Response<Long> create(@RequestBody BannerSaveRequest request) {
        return bannerService.create(request);

    }

    /**
     * banner 修改
     */
    @PutMapping("/banner/modify")
    public Response<Long> modify(@RequestBody BannerSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return bannerService.modify(request);
    }


}
