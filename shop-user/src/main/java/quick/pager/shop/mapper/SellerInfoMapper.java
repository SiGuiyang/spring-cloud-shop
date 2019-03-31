package quick.pager.shop.mapper;

import quick.pager.shop.SellerInfo;

public interface SellerInfoMapper {

    int insertSelective(SellerInfo record);

    SellerInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SellerInfo record);

}