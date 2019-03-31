package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.BannerDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.BannerService;

/**
 * banner
 */
@Api(description = "banner接口")
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
public class BannerController {


    @Autowired
    private BannerService bannerService;

    @ApiOperation("客户端banner列表")
    @PostMapping("/banner/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bannerType", value = "banner类型", required = true, dataType = "String", paramType = "query")})
    public Response banners(@RequestParam String bannerType) {
        BannerDTO dto = new BannerDTO();
        dto.setBannerType(bannerType);
        return bannerService.doService(dto);
    }
}
