package quick.pager.shop.seller.mapper;

import quick.pager.shop.model.seller.SellerInfo;

public interface SellerInfoMapper {

    int insertSelective(SellerInfo record);

    SellerInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SellerInfo record);

}