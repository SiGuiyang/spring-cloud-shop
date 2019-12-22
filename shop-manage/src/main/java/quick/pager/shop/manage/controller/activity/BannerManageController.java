package quick.pager.shop.manage.controller.activity;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.manage.param.banner.BannerPageParam;
import quick.pager.shop.manage.param.banner.BannerSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.activity.BannerService;

/**
 * banner 管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class BannerManageController {

    @Autowired
    private BannerService bannerService;

    /**
     * banner 列表
     */
    @PostMapping("/activity/banner/list")
    public Response<List<BannerResponse>> list(@RequestBody BannerPageParam param) {
        return bannerService.queryPage(param);
    }

    /**
     * banner 新增
     */
    @PostMapping("/activity/banner/create")
    public Response<Long> create(@RequestBody BannerSaveParam param) {
        return bannerService.create(param);
    }

    /**
     * banner 修改
     */
    @PutMapping("/activity/banner/modify")
    public Response<Long> modify(@RequestBody BannerSaveParam param) {
        if (Objects.isNull(param.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return bannerService.modify(param);
    }

    /**
     * 根据banner类型查询列表
     */
    @PostMapping("/activity/banner/listAll")
    public Response listAll(@RequestBody BannerPageParam param) {
        return bannerService.listAll(param);
    }

}
