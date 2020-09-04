package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.mapper.AddressMapper;
import quick.pager.shop.model.Address;
import quick.pager.shop.param.UserAddressSaveParam;
import quick.pager.shop.user.response.AddressResponse;
import quick.pager.shop.service.AddressService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * AddressServiceImpl
 *
 * @author siguiyang
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    @Override
    public Response<List<AddressResponse>> queryPage(Long userId, Integer page) {
        Response<List<Address>> response = this.toPage(page, IConsts.TEN, new LambdaQueryWrapper<Address>()
                .eq(Address::getDeleteStatus, Boolean.FALSE)
                .eq(Address::getUserId, userId));
        return Response.toResponse(response.getData().stream().map(this::convert).collect(Collectors.toList())
                , response.getTotal());
    }

    @Override
    public Long create(UserAddressSaveParam param) {
        Address address = this.convert(param);
        address.setDeleteStatus(Boolean.FALSE);
        address.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(address);
        return address.getId();
    }

    @Override
    public Long modify(UserAddressSaveParam param) {
        Address address = this.convert(param);
        this.baseMapper.updateById(address);
        return address.getId();
    }

    @Override
    public AddressResponse queryByPrimaryKey(Long addressId) {
        Address address = this.baseMapper.selectById(addressId);
        return this.convert(address);
    }

    /**
     * Address -> AddressResponse
     *
     * @param address 参数
     * @return AddressResponse
     */
    private AddressResponse convert(Address address) {
        return BeanCopier.copy(address, new AddressResponse());
    }

    /**
     * UserAddressSaveParam -> Address
     *
     * @param param 参数
     * @return Address
     */
    private Address convert(UserAddressSaveParam param) {
        return BeanCopier.copy(param, new Address());
    }
}
