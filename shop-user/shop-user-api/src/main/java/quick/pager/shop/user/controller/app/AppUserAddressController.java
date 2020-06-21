package quick.pager.shop.user.controller.app;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.user.param.UserAddressPageParam;
import quick.pager.shop.user.param.UserAddressSaveParam;
import quick.pager.shop.user.response.AddressResponse;
import quick.pager.shop.user.service.AddressService;

/**
 * 地址管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class AppUserAddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 地址列表
     *
     * @param userId 用户主键
     * @param page   页码
     */
    @GetMapping("/app/address/{userId}/{page}")
    public Response<List<AddressResponse>> page(@PathVariable("userId") Long userId, @PathVariable("page") Integer page) {
        return addressService.queryPage(userId, page);
    }

    /**
     * 新增地址
     *
     * @param param 请求参数
     */
    @PostMapping("/app/address/create")
    public Response<Long> create(@RequestBody UserAddressSaveParam param) {
        Long addressId = addressService.create(param);
        return new Response<>(addressId);
    }

    /**
     * 修改地址
     *
     * @param param 请求参数
     */
    @PostMapping("/app/address/modify")
    public Response<Long> modify(@RequestBody UserAddressSaveParam param) {

        if (Objects.isNull(param.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        Long addressId = addressService.modify(param);
        return new Response<>(addressId);
    }

    /**
     * 根据地址主键查询地址信息
     *
     * @param addressId 地址主键
     */
    @GetMapping("/app/address/{addressId}")
    public Response<AddressResponse> address(@PathVariable("addressId") Long addressId) {

        return new Response<>(addressService.queryByPrimaryKey(addressId));
    }
}
