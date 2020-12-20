package quick.pager.shop.controller.app;

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
import quick.pager.shop.model.LoginUser;
import quick.pager.shop.user.request.UserAddressSaveRequest;
import quick.pager.shop.user.response.AddressResponse;
import quick.pager.shop.user.response.AppAddressResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.AddressService;
import quick.pager.shop.util.AuthUtils;
import quick.pager.shop.utils.Assert;

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
     * @param page 页码
     */
    @PostMapping("/app/address/{page}")
    public Response<List<AppAddressResponse>> page(@PathVariable("page") Integer page) {
        // 获取当前登录人
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return addressService.queryPage(principal.getId(), page);
    }

    /**
     * 新增地址
     *
     * @param request 请求参数
     */
    @PostMapping("/app/address/create")
    public Response<Long> create(@RequestBody UserAddressSaveRequest request) {
        return addressService.create(request);
    }

    /**
     * 修改地址
     *
     * @param request 请求参数
     */
    @PostMapping("/app/address/modify")
    public Response<Long> modify(@RequestBody UserAddressSaveRequest request) {

        Assert.isTrue(Objects.nonNull(request.getId()), () -> ResponseStatus.PARAMS_EXCEPTION);
        return addressService.modify(request);
    }

    /**
     * 根据地址主键查询地址信息
     *
     * @param addressId 地址主键
     */
    @PostMapping("/app/{addressId}/address")
    public Response<AddressResponse> address(@PathVariable("addressId") Long addressId) {

        return Response.toResponse(addressService.queryByPrimaryKey(addressId));
    }
}
