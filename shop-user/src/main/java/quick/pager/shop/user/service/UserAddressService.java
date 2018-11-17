package quick.pager.shop.user.service;

import com.alibaba.fastjson.JSON;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.model.user.ShippingAddress;
import quick.pager.shop.user.dto.AddressDTO;
import quick.pager.shop.user.mapper.ShippingAddressMapper;

/**
 * 地址管理服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class UserAddressService implements IService {

    @Autowired
    private ShippingAddressMapper shippingAddressMapper;

    @Override
    public Response doService(DTO dto) {
        log.info("调用地址服务入参 params = {}", JSON.toJSONString(dto));
        AddressDTO addressDTO = (AddressDTO) dto;

        Response response = new Response();
        // 查询地址列表
        if (StringUtils.isEmpty(addressDTO.getEvent())) {
            List<ShippingAddress> shippingAddress = shippingAddressMapper.selectAddressByUserId(addressDTO.getUserId());
            response.setData(shippingAddress);
            return response;
        }
        // 新增一个地址
        if (null == addressDTO.getId() || 0 == addressDTO.getId()) {
            log.info("用户新增地址 userId = {}", addressDTO.getUserId());
            ShippingAddress address = new ShippingAddress();
            address.setArea(address.getArea());
            address.setDefaultAddress(addressDTO.getDefaultAddress());
            address.setDetailAddress(addressDTO.getDetailAddress());
            address.setLabel(addressDTO.getLabel());
            address.setPhone(addressDTO.getPhone());
            address.setUserId(addressDTO.getUserId());
            address.setUsername(addressDTO.getUsername());
            address.setCreateTime(new Date());
            shippingAddressMapper.insertSelective(address);
            return response;
        }

        ShippingAddress shippingAddress = shippingAddressMapper.selectByPrimaryKey(addressDTO.getId());
        // 未找到要修改的地址
        if (ObjectUtils.isEmpty(shippingAddress)) {
            log.info("客户端入参异常，未知地址 userId = {}", addressDTO.getUserId());
            response.setCode(ResponseStatus.Code.FAIL_CODE);
            response.setMsg(ResponseStatus.PARAMS_EXCEPTION);
            return response;
        }

        // 修改地址
        ShippingAddress address = new ShippingAddress();
        address.setArea(address.getArea());
        address.setDefaultAddress(addressDTO.getDefaultAddress());
        address.setDetailAddress(addressDTO.getDetailAddress());
        address.setLabel(addressDTO.getLabel());
        address.setPhone(addressDTO.getPhone());
        address.setUserId(addressDTO.getUserId());
        address.setUsername(addressDTO.getUsername());
        address.setId(shippingAddress.getId());

        shippingAddressMapper.updateByPrimaryKeySelective(address);

        return response;
    }
}
