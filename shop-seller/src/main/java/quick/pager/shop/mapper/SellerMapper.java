package quick.pager.shop.mapper;

import quick.pager.shop.Seller;

public interface SellerMapper {

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Seller record);

}