package quick.pager.shop.seller.mapper;

import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.seller.model.Seller;

@Mapper
public interface SellerMapper {

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Seller record);

}
