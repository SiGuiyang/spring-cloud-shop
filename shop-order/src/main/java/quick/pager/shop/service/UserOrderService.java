package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.dto.OrderDTO;
import quick.pager.shop.model.UserOrder;
import quick.pager.shop.response.OrderResponse;
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
    Response<List<OrderResponse>> userOrderList(OrderDTO dto);

    /**
     * 用户订单详情
     *
     * @param orderId 订单Id
     */
    Response<OrderResponse> userOrderDetail(Long orderId);

    /**
     * 创建订单
     */
    Response orderCreate(UserOrder userOrder);
}
