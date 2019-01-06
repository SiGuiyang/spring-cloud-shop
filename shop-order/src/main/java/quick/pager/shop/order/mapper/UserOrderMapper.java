package quick.pager.shop.order.mapper;

import quick.pager.shop.model.order.UserOrder;

public interface UserOrderMapper {

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserOrder record);

}