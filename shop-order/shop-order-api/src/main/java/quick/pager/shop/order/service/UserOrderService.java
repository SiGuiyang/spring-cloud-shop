package quick.pager.shop.order.service;

import java.util.List;
import quick.pager.shop.order.model.UserOrder;
import quick.pager.shop.order.request.OrderRequest;
import quick.pager.shop.order.request.UserOrderSaveRequest;
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
    Response<List<Object>> userOrderList(OrderRequest request);

    /**
     * 用户订单详情
     *
     * @param orderId 订单Id
     */
    Response<Object> userOrderDetail(Long orderId);

    /**
     * 创建订单
     */
    Response orderCreate(UserOrderSaveRequest request);
}
