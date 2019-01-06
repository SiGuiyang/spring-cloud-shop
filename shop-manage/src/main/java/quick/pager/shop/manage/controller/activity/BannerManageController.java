package quick.pager.shop.manage.controller.activity;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.dto.BannerDTO;
import quick.pager.shop.manage.request.BannerRequest;
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

    @ApiOperation("banner 列表")
    @PostMapping("/activity/banner/list")
    public Response list(BannerRequest request) {
        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setTitle(request.getTitle());
        bannerDTO.setBannerType(request.getBannerType());
        bannerDTO.setPage(request.getPage());
        bannerDTO.setPageSize(request.getPageSize());
        bannerDTO.setEvent(Constants.Event.LIST);
        return bannerService.doService(bannerDTO);
    }

    @ApiOperation("banner 新增|修改|")
    @PostMapping("/activity/banner/modify")
    public Response modify(BannerRequest request) {

        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setId(request.getId());
        bannerDTO.setTitle(request.getTitle());
        bannerDTO.setBannerUrl(request.getBannerUrl());
        bannerDTO.setBannerType(request.getBannerType());
        bannerDTO.setShareChannel(request.getShareChannel());
        bannerDTO.setBannerClickUrl(request.getBannerClickUrl());
        bannerDTO.setShareIcon(request.getShareIcon());
        bannerDTO.setShareSubtitle(request.getShareSubtitle());
        bannerDTO.setShareTitle(request.getShareTitle());
        bannerDTO.setShareUrl(request.getShareUrl());
        bannerDTO.setCreateUser(request.getCreateUser());
        bannerDTO.setDeleteStatus(request.getDeleteStatus());

        bannerDTO.setEvent(request.getEvent());

        return bannerService.doService(bannerDTO);
    }

}
