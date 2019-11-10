package quick.pager.shop.controller.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.activity.BannerDTO;
import quick.pager.shop.service.activity.BannerService;

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
    public Response list(@RequestBody BannerDTO dto) {
        return bannerService.fetch(dto);
    }

    /**
     * banner 新增
     */
    @PostMapping("/activity/banner/create")
    public Response create(@RequestBody BannerDTO dto) {
        return bannerService.create(dto);
    }

    /**
     * banner 修改
     */
    @PutMapping("/activity/banner/modify")
    public Response modify(@RequestBody BannerDTO dto) {
        return bannerService.modify(dto);
    }

    /**
     * 根据banner类型查询列表
     */
    @PostMapping("/activity/banner/listAll")
    public Response listAll(@RequestBody BannerDTO dto) {
        return bannerService.listAll(dto);
    }

}
