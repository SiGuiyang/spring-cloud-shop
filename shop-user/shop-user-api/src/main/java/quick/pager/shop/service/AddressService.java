package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.user.request.UserAddressSaveRequest;
import quick.pager.shop.user.response.AddressResponse;
import quick.pager.shop.user.response.AppAddressResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.model.Address;

/**
 * 地址接口服务
 *
 * @author siguiyang
 */
public interface AddressService extends IService<Address> {

    /**
     * 地址列表分页
     *
     * @param userId 用户主键
     * @param page   页码
     * @return 地址列表
     */
    Response<List<AppAddressResponse>> queryPage(final Long userId, final Integer page);

    /**
     * 新增
     *
     * @param request 新增参数
     * @return 地址主键
     */
    Response<Long> create(final UserAddressSaveRequest request);

    /**
     * 修改
     *
     * @param request 修改参数
     * @return 地址主键
     */
    Response<Long> modify(final UserAddressSaveRequest request);


    /**
     * 根据主键查询地址信息
     *
     * @param addressId 主键
     * @return 地址
     */
    AddressResponse queryByPrimaryKey(final Long addressId);

    /**
     * 查询用户默认地址
     *
     * @param userId 用户主键
     */
    Response<AddressResponse> address(final Long userId);
}
