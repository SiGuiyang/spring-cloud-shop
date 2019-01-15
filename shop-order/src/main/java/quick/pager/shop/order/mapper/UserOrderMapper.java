package quick.pager.shop.order.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.order.UserOrder;

public interface UserOrderMapper {

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserOrder record);

    /**
     * 查询用户订单
     *
     * @param userId          用户Id
     * @param orderStatusList 订单状态
     * @param page            页码
     * @param pageSize        页数
     */
    List<UserOrder> selectOrders(@Param("userId") Long userId, @Param("orderStatusList") List<String> orderStatusList,
                                 @Param("page") Integer page, @Param("pageSize") Integer pageSize);

    /**
     * 管理后台查询用户订单
     */
    List<UserOrder> selectUserOrders(@Param("phone") String phone, @Param("orderCode") String orderCode,
                                     @Param("orderStatus") String orderStatus, @Param("orderType") Integer orderType,
                                     @Param("beginTime") String beginTime, @Param("endTime") String endTime);
}