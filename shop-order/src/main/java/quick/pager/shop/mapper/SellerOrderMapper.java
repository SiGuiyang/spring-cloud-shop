package quick.pager.shop.mapper;


import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.order.SellerOrder;

@Mapper
public interface SellerOrderMapper {

    int insertSelective(SellerOrder record);

    SellerOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SellerOrder record);

}
