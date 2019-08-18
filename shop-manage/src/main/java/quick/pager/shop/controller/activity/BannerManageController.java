package quick.pager.shop.controller.activity;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.BindingResultUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.BannerDTO;
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

    @ApiOperation("banner 列表")
    @PostMapping("/activity/banner/list")
    public Response list(BannerDTO dto) {
        return bannerService.fetch(dto);
    }

    @ApiOperation("banner 修改")
    @PutMapping("/activity/banner/modify")
    public Response addBanner(@Valid BannerDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return bannerService.addBanner(dto);
    }

    @ApiOperation("banner 新增")
    @PostMapping("/activity/banner/modify")
    public Response modifyBanner(@Valid BannerDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return bannerService.modifyBanner(dto);
    }

}
