package quick.pager.shop.order.service;

import java.util.List;
import quick.pager.shop.order.request.OrderPageRequest;
import quick.pager.shop.order.request.UserOrderSaveRequest;
import quick.pager.shop.order.response.OrderResponse;
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
    Response<List<OrderResponse>> queryPage(OrderPageRequest request);

    /**
     * 用户订单详情
     *
     * @param orderId 订单Id
     */
    Response<Object> detail(Long orderId);

    /**
     * 创建订单
     */
    Response<Long> create(UserOrderSaveRequest request);
}
