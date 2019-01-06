package quick.pager.shop.user.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.common.Address;

public interface AddressMapper {

    int insertSelective(Address record);

    Address selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Address record);


    /**
     * 查询用户地址列表
     *
     * @param userId 用户Id
     */
    List<Address> selectAddressByUserId(@Param("userId") Long userId);


}