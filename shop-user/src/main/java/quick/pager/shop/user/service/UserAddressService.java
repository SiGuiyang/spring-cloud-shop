package quick.pager.shop.user.service;

import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.model.common.Address;
import quick.pager.shop.model.user.ShippingAddress;
import quick.pager.shop.user.dto.AddressDTO;
import quick.pager.shop.user.mapper.AddressMapper;

/**
 * 地址管理服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class UserAddressService implements IService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Response doService(BaseDTO dto) {
        AddressDTO addressDTO = (AddressDTO) dto;

        Response response = new Response();
        // 查询地址列表
        if (StringUtils.isEmpty(addressDTO.getEvent())) {
            List<Address> address = addressMapper.selectAddressByUserId(addressDTO.getUserId());
            response.setData(address);
            return response;
        }
        // 新增一个地址
        if (null == addressDTO.getId() || 0 == addressDTO.getId()) {
            log.info("用户新增地址 userId = {}", addressDTO.getUserId());
            Address address = new Address();
            address.setArea(address.getArea());
            address.setDefaultAddress(addressDTO.getDefaultAddress());
            address.setDetailAddress(addressDTO.getDetailAddress());
            address.setLabel(addressDTO.getLabel());
            address.setPhone(addressDTO.getPhone());
            address.setUserId(addressDTO.getUserId());
            address.setUsername(addressDTO.getUsername());
            address.setCreateTime(new Date());
            addressMapper.insertSelective(address);
            return response;
        }

        Address address = addressMapper.selectByPrimaryKey(addressDTO.getId());
        // 未找到要修改的地址
        if (ObjectUtils.isEmpty(address)) {
            log.info("客户端入参异常，未知地址 userId = {}", addressDTO.getUserId());
            response.setCode(ResponseStatus.Code.FAIL_CODE);
            response.setMsg(ResponseStatus.PARAMS_EXCEPTION);
            return response;
        }

        // 修改地址
        ShippingAddress updateAddress = new ShippingAddress();
        updateAddress.setArea(address.getArea());
        updateAddress.setDefaultAddress(addressDTO.getDefaultAddress());
        updateAddress.setDetailAddress(addressDTO.getDetailAddress());
        updateAddress.setLabel(addressDTO.getLabel());
        updateAddress.setPhone(addressDTO.getPhone());
        updateAddress.setUserId(addressDTO.getUserId());
        updateAddress.setUsername(addressDTO.getUsername());
        updateAddress.setId(address.getId());

        addressMapper.updateByPrimaryKeySelective(address);

        return response;
    }
}
