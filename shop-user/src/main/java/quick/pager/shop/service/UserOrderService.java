package quick.pager.shop.service;

import quick.pager.shop.dto.order.OrderDTO;
import quick.pager.shop.dto.UserOrderDTO;
import quick.pager.shop.response.Response;

public interface UserOrderService {


    /**
     * 订单列表
     */
    Response orders(OrderDTO dto);

    /**
     * 订单详情
     * @param orderId 订单Id
     */
    Response orderInfo(Long orderId);

    /**
     * 下单
     */
    Response createOrder(UserOrderDTO dto);
}
