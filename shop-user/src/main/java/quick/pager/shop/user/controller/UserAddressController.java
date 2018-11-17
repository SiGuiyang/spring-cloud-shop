package quick.pager.shop.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.response.Response;
import quick.pager.shop.user.dto.AddressDTO;
import quick.pager.shop.user.response.AreaResponse;
import quick.pager.shop.user.request.AddressRequest;
import quick.pager.shop.user.service.AreaService;
import quick.pager.shop.user.service.UserAddressService;

/**
 * 地址管理
 *
 * @author siguiyang
 */
@RestController
@Api(description = "地址管理")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private AreaService areaService;

    @PostMapping("/user/address/{userId}")
    @ApiOperation("地址列表")
    public Response address(@PathVariable("userId") Long userId) {
        return userAddressService.doService(AddressDTO.builder().userId(userId).build());
    }

    @PostMapping("/user/modify/address")
    @ApiOperation("地址修改")
    public Response modifyAddress(AddressRequest request) {
        AddressDTO dto = AddressDTO.builder()
                .event(request.getEvent())
                .userId(request.getUserId())
                .area(request.getArea())
                .defaultAddress(request.getDefaultAddress())
                .detailAddress(request.getDetailAddress())
                .phone(request.getPhone())
                .label(request.getLabel())
                .username(request.getUsername())
                .build();
        return userAddressService.doService(dto);
    }


    @PostMapping("/user/areas")
    @ApiOperation("省市区")
    public Response<AreaResponse> areas() {
        return areaService.doService(null);
    }

}
