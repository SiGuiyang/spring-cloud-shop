package quick.pager.shop.mapper;


import quick.pager.shop.model.SellerOrder;

public interface SellerOrderMapper {

    int insertSelective(SellerOrder record);

    SellerOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SellerOrder record);

}
