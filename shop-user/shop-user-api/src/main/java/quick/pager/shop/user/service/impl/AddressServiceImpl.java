package quick.pager.shop.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.response.Response;
import quick.pager.shop.user.mapper.AddressMapper;
import quick.pager.shop.user.model.Address;
import quick.pager.shop.user.param.UserAddressSaveParam;
import quick.pager.shop.user.response.AddressResponse;
import quick.pager.shop.user.service.AddressService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * AddressServiceImpl
 *
 * @author siguiyang
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public Response<List<AddressResponse>> queryPage(Long userId, Integer page) {
        LambdaQueryWrapper<Address> qw = new LambdaQueryWrapper<Address>()
                .eq(Address::getDeleteStatus, Boolean.FALSE)
                .eq(Address::getUserId, userId);

        int total = addressMapper.selectCount(qw);

        List<AddressResponse> list = Collections.emptyList();
        if (0 < total) {
            List<Address> addressList = addressMapper.selectPage(new Page<>(page, IConsts.TEN), qw).getRecords();
            list = addressList.stream().map(this::convert).collect(Collectors.toList());
        }

        return Response.toResponse(list, total);
    }

    @Override
    public Long create(UserAddressSaveParam param) {
        Address address = this.convert(param);
        address.setDeleteStatus(Boolean.FALSE);
        address.setCreateTime(DateUtils.dateTime());
        addressMapper.insert(address);
        return address.getId();
    }

    @Override
    public Long modify(UserAddressSaveParam param) {
        Address address = this.convert(param);
        addressMapper.updateById(address);
        return address.getId();
    }

    @Override
    public AddressResponse queryByPrimaryKey(Long addressId) {
        Address address = addressMapper.selectById(addressId);
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
