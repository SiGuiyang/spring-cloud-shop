package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.UserOrder;
import quick.pager.shop.order.request.OrderPageRequest;
import quick.pager.shop.order.request.UserOrderSaveRequest;
import quick.pager.shop.order.response.UserOrderResponse;
import quick.pager.shop.user.response.Response;

/**
 * 用户订单
 *
 * @author siguiyang
 */
public interface UserOrderService extends IService<UserOrder> {

    /**
     * 查看用户订单列表
     */
    Response<List<UserOrderResponse>> queryPage(final OrderPageRequest request);

    /**
     * 用户订单详情
     *
     * @param orderId 订单Id
     */
    Response<Object> detail(final Long orderId);
}
