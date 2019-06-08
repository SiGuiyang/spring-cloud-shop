package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.SellerInfo;

@Mapper
public interface SellerInfoMapper {

    int insertSelective(SellerInfo record);

    SellerInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SellerInfo record);

}
