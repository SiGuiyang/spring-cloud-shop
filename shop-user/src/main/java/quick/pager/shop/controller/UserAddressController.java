package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.AddressDTO;
import quick.pager.shop.response.AreaResponse;
import quick.pager.shop.service.AreaService;
import quick.pager.shop.service.UserAddressService;

/**
 * 地址管理
 *
 * @author siguiyang
 */
@Api(description = "地址管理")
@RestController
@RequestMapping(Constants.Module.USER)
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private AreaService areaService;

    @ApiOperation("地址列表")
    @PostMapping("/address/{userId}")
    public Response address(@PathVariable("userId") Long userId) {
        AddressDTO dto = new AddressDTO();
        dto.setUserId(userId);
        return userAddressService.doService(dto);
    }

    @ApiOperation("地址修改")
    @PostMapping("/modify/address")
    public Response modifyAddress(AddressDTO dto) {

        return userAddressService.doService(dto);
    }


    @PostMapping("/areas")
    @ApiOperation("省市区")
    public Response<AreaResponse> areas() {
        return areaService.doService(null);
    }

}
