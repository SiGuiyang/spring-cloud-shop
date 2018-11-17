package quick.pager.shop.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.user.ShippingAddress;

public interface ShippingAddressMapper {

    int insertSelective(ShippingAddress record);

    ShippingAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShippingAddress record);

    /**
     * 查询用户地址列表
     *
     * @param userId 用户Id
     */
    List<ShippingAddress> selectAddressByUserId(@Param("userId") Long userId);

}