package quick.pager.shop.order.mapper;


import quick.pager.shop.model.order.SellerOrder;

public interface SellerOrderMapper {

    int insertSelective(SellerOrder record);

    SellerOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SellerOrder record);

}