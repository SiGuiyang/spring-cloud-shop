package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.BannerDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.BannerService;
import quick.pager.shop.service.client.BannerClientService;

/**
 * banner
 */
@Api(description = "banner接口")
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
public class BannerController {


    @Autowired
    private BannerService bannerService;

    @Autowired
    private BannerClientService bannerClientService;

    @ApiOperation("客户端banner列表")
    @PostMapping("/banner/app/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bannerType", value = "banner类型", required = true, dataType = "String", paramType = "query")})
    public Response banners(@RequestParam String bannerType) {
        BannerDTO dto = new BannerDTO();
        dto.setBannerType(bannerType);
        return bannerService.doService(dto);
    }


    @ApiOperation("banner 列表")
    @PostMapping("/banner/list")
    public Response fetch(@RequestBody BannerDTO bannerDTO) {
        bannerDTO.setEvent(Constants.Event.LIST);
        return bannerClientService.doService(bannerDTO);
    }

    @ApiOperation("banner 修改|")
    @PutMapping("/banner/modify")
    public Response modify(@RequestBody BannerDTO bannerDTO) {
        bannerDTO.setEvent(Constants.Event.MODIFY);
        return bannerClientService.doService(bannerDTO);
    }

    @ApiOperation("banner 新增|")
    @PostMapping("/banner/modify")
    public Response add(@RequestBody BannerDTO bannerDTO) {
        bannerDTO.setEvent(Constants.Event.ADD);
        return bannerClientService.doService(bannerDTO);

    }
}
