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
import quick.pager.shop.model.feign.dto.BannerDTO;
import quick.pager.shop.model.feign.request.BannerRequest;

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
    public Response fetch(@RequestBody BannerRequest request) {
        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setTitle(request.getTitle());
        bannerDTO.setBannerType(request.getBannerType());
        bannerDTO.setPage(request.getPage());
        bannerDTO.setPageSize(request.getPageSize());
        bannerDTO.setEvent(Constants.Event.LIST);
        return bannerClientService.doService(bannerDTO);
    }

    @ApiOperation("banner 新增|修改|")
    @PostMapping("/banner/modify")
    public Response modify(@RequestBody BannerRequest request) {

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

        return bannerClientService.doService(bannerDTO);
    }
}
