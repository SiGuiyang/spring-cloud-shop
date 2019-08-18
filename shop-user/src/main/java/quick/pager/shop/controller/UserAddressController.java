package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.BindingResultUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
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

    @ApiOperation("查询地址")
    @PostMapping("/address/{addressId}")
    public Response address(@PathVariable("addressId") Long addressId) {
        AddressDTO dto = new AddressDTO();
        dto.setEvent(Constants.Event.INFO);
        dto.setId(addressId);
        return userAddressService.doService(dto);
    }

    @ApiOperation("地址列表")
    @PostMapping("/address/list/{userId}")
    public Response addressList(@PathVariable("userId") Long userId) {
        AddressDTO dto = new AddressDTO();
        dto.setUserId(userId);
        dto.setEvent(Constants.Event.LIST);
        return userAddressService.doService(dto);
    }

    @ApiOperation("地址修改")
    @PostMapping("/modify/address")
    public Response modifyAddress(@RequestBody @Valid AddressDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        dto.setEvent(Constants.Event.MODIFY);
        return userAddressService.doService(dto);
    }


    @PostMapping("/areas")
    @ApiOperation("省市区")
    public Response<AreaResponse> areas() {
        return areaService.doService(null);
    }

}
