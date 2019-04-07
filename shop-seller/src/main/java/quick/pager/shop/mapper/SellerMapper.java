package quick.pager.shop.mapper;

import quick.pager.shop.model.Seller;

public interface SellerMapper {

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Seller record);

}
