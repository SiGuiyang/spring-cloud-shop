package quick.pager.shop.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.user.model.Address;

@Mapper
public interface AddressMapper extends BaseMapper<Address> {

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
