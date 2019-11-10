package quick.pager.shop.controller;

import com.google.common.base.Joiner;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.activity.BannerDTO;
import quick.pager.shop.model.activity.Banner;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.BannerService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;
import quick.pager.shop.utils.DateUtils;

/**
 * banner管理
 */
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
public class BannerController {


    @Autowired
    private BannerService bannerService;

    /**
     * banner 列表
     */
    @PostMapping("/banner/list")
    public Response<List<Banner>> list(@RequestBody BannerDTO bannerDTO) {
        return bannerService.list(bannerDTO);
    }

    /**
     * banner 新增
     */
    @PostMapping("/banner/create")
    public Response add(@RequestBody BannerDTO bannerDTO) {
        Banner banner = this.convert(bannerDTO);
        doChannel(banner, bannerDTO);
        banner.setCreateTime(DateUtils.dateTime());
        bannerService.save(banner);
        return new Response();

    }

    /**
     * banner 修改
     */
    @PutMapping("/banner/modify")
    public Response modify(@RequestBody BannerDTO bannerDTO) {
        Banner banner = this.convert(bannerDTO);
        doChannel(banner, bannerDTO);
        bannerService.updateById(banner);
        return new Response();
    }

    /**
     * 根据banner类型查询列表
     */
    @PostMapping("/banner/listAll")
    public Response listAll(@RequestBody BannerDTO bannerDTO) {
        return bannerService.getBanners(bannerDTO.getBannerType());
    }

    /**
     * 数据转换
     */
    private Banner convert(BannerDTO dto) {
        return BeanCopier.create(dto, new Banner(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true))
                .copy();
    }

    private void doChannel(Banner banner, BannerDTO dto) {
        if (CollectionUtils.isEmpty(dto.getShareChannel())) {
            banner.setShareChannel(null);
        } else {
            banner.setShareChannel(Joiner.on(Constants.COMMA).join(dto.getShareChannel()));
        }
    }
}
