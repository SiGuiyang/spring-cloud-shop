package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.dto.order.OrderDTO;
import quick.pager.shop.model.order.UserOrder;
import quick.pager.shop.response.Response;

/**
 * 用户订单
 *
 * @author siguiyang
 */
public interface UserOrderService {

    /**
     * 查看用户订单列表
     */
    Response<List<Object>> userOrderList(OrderDTO dto);

    /**
     * 用户订单详情
     *
     * @param orderId 订单Id
     */
    Response<Object> userOrderDetail(Long orderId);

    /**
     * 创建订单
     */
    Response orderCreate(UserOrder userOrder);
}
