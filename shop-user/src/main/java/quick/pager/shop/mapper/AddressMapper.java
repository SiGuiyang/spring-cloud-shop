package quick.pager.shop.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.Address;

public interface AddressMapper {

    int insertSelective(Address record);

    Address selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Address record);

    /**
     * 根据id批量获取地址
     */
    List<Address> selectBatchByPrimaryKey(List<Long> id);

    /**
     * 查询用户地址列表
     *
     * @param userId 用户Id
     */
    List<Address> selectAddressByUserId(@Param("userId") Long userId);


}
