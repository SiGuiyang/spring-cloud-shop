package quick.pager.shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.user.response.AreaResponse;
import quick.pager.shop.user.service.AreaService;
import quick.pager.shop.user.service.UserAddressService;

/**
 * 地址管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private AreaService areaService;

    /**
     * 查询地址
     */
    @PostMapping("/address/{addressId}")
    public Response address(@PathVariable("addressId") Long addressId) {
//        AddressDTO dto = new AddressDTO();
//        dto.setEvent(Constants.Event.INFO);
//        dto.setId(addressId);
//        return userAddressService.doService(dto);
        return null;
    }

    /**
     * 地址列表
     */
    @PostMapping("/address/list/{userId}")
    public Response addressList(@PathVariable("userId") Long userId) {
//        AddressDTO dto = new AddressDTO();
//        dto.setUserId(userId);
//        dto.setEvent(Constants.Event.LIST);
//        return userAddressService.doService(dto);
        return null;
    }

    /**
     * 地址修改
     */
    @PostMapping("/modify/address")
    public Response modifyAddress() {
//        BindingResultUtils.getFieldErrorMessage(bindingResult);
//        dto.setEvent(Constants.Event.MODIFY);
//        return userAddressService.doService(dto);
        return null;
    }


    /**
     * 省市区
     */
    @PostMapping("/areas")
    public Response<AreaResponse> areas() {
        return areaService.doService(null);
    }

}
