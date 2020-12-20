package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.user.request.UserAddressSaveRequest;
import quick.pager.shop.user.response.AppAddressResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.mapper.AddressMapper;
import quick.pager.shop.model.Address;
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
    public Response<List<AppAddressResponse>> queryPage(final Long userId, final Integer page) {
        Response<List<Address>> response = this.toPage(page, IConsts.TEN, new LambdaQueryWrapper<Address>()
                .eq(Address::getDeleteStatus, Boolean.FALSE)
                .eq(Address::getUserId, userId));
        return Response.toResponse(response.getData().stream().map(this::convertList).collect(Collectors.toList())
                , response.getTotal());
    }

    @Override
    public Response<Long> create(final UserAddressSaveRequest request) {
        Address address = this.convert(request);
        address.setDeleteStatus(Boolean.FALSE);
        address.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(address);
        return Response.toResponse(address.getId());
    }

    @Override
    public Response<Long> modify(final UserAddressSaveRequest request) {
        Address address = this.convert(request);
        this.baseMapper.updateById(address);
        return Response.toResponse(address.getId());
    }

    @Override
    public AddressResponse queryByPrimaryKey(final Long addressId) {
        Address address = this.baseMapper.selectById(addressId);
        return this.convert(address);
    }

    @Override
    public Response<AddressResponse> address(final Long userId) {

        Address address = this.baseMapper.selectOne(new LambdaQueryWrapper<Address>()
                .eq(Address::getUserId, userId)
                .eq(Address::getDefaultAddress, Boolean.TRUE));
        return Objects.isNull(address) ? Response.toResponse() : Response.toResponse(this.convert(address));
    }

    /**
     * Address -> AddressResponse
     *
     * @param address 参数
     * @return AddressResponse
     */
    private AddressResponse convert(final Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .userId(address.getUserId())
                .cityName(address.getCityName())
                .defaultAddress(address.getDefaultAddress())
                .houseNumber(address.getHouseNumber())
                .label(address.getLabel())
                .latitude(address.getLatitude())
                .longitude(address.getLongitude())
                .mobile(address.getMobile())
                .username(address.getUsername())
                .build();
    }

    /**
     * Address -> AddressResponse
     *
     * @param address 参数
     * @return AddressResponse
     */
    private AppAddressResponse convertList(final Address address) {
        return AppAddressResponse.builder()
                .id(address.getId())
                .name(address.getUsername())
                .tel(address.getMobile())
                .address(address.getCityName().concat(address.getDeliveryAddress()).concat(address.getHouseNumber()))
                .isDefault(address.getDefaultAddress())
                .build();
    }

    /**
     * UserAddressSaveRequest -> Address
     *
     * @param request 参数
     * @return Address
     */
    private Address convert(final UserAddressSaveRequest request) {
        return BeanCopier.copy(request, new Address());
    }
}
