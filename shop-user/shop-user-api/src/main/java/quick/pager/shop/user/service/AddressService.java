package quick.pager.shop.user.service;

import java.util.List;
import quick.pager.shop.response.Response;
import quick.pager.shop.user.model.Address;
import quick.pager.shop.user.param.UserAddressSaveParam;
import quick.pager.shop.user.response.AddressResponse;

/**
 * 地址接口服务
 *
 * @author siguiyang
 */
public interface AddressService {

    /**
     * 地址列表分页
     *
     * @param userId 用户主键
     * @param page   页码
     * @return 地址列表
     */
    Response<List<AddressResponse>> queryPage(Long userId, Integer page);

    /**
     * 新增
     *
     * @param param 新增参数
     * @return 地址主键
     */
    Long create(UserAddressSaveParam param);

    /**
     * 修改
     *
     * @param param 修改参数
     * @return 地址主键
     */
    Long modify(UserAddressSaveParam param);


    /**
     * 根据主键查询地址信息
     *
     * @param addressId 主键
     * @return 地址
     */
    AddressResponse queryByPrimaryKey(Long addressId);


}
