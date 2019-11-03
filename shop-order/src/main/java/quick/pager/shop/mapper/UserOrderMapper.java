package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.order.UserOrder;

public interface UserOrderMapper extends BaseMapper<UserOrder> {


    /**
     * 查询用户订单列表
     *
     * @param userId      用户Id
     * @param phone       手机号
     * @param orderCode   订单号
     * @param orderStatusList 订单状态
     * @param orderType   订单类型
     * @param beginTime   开始时间
     * @param endTime     结束时间
     */
    List<UserOrder> selectOrders(@Param("userId") Long userId,
                                 @Param("phone") String phone,
                                 @Param("orderCode") String orderCode,
                                 @Param("orderStatusList") List<String> orderStatusList,
                                 @Param("orderType") Integer orderType,
                                 @Param("beginTime") String beginTime,
                                 @Param("endTime") String endTime);

    /**
     * 查询用户订单总数
     *
     * @param userId      用户Id
     * @param phone       手机号
     * @param orderCode   订单号
     * @param orderStatusList 订单状态
     * @param orderType   订单类型
     * @param beginTime   开始时间
     * @param endTime     结束时间
     * @param page        页码
     * @param pageSize    页数
     */
    long selectCountOrders(@Param("userId") Long userId,
                           @Param("phone") String phone,
                           @Param("orderCode") String orderCode,
                           @Param("orderStatusList") List<String> orderStatusList,
                           @Param("orderType") Integer orderType,
                           @Param("beginTime") String beginTime,
                           @Param("endTime") String endTime,
                           @Param("page") Integer page,
                           @Param("pageSize") Integer pageSize);
}
