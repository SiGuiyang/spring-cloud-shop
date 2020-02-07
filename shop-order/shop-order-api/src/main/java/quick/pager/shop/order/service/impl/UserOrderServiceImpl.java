package quick.pager.shop.order.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import quick.pager.shop.order.request.OrderPageRequest;
import quick.pager.shop.order.request.UserOrderSaveRequest;
import quick.pager.shop.order.response.OrderResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.order.service.UserOrderService;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Override
    public Response<List<OrderResponse>> queryPage(OrderPageRequest request) {
        return null;
    }

    @Override
    public Response<Object> detail(Long orderId) {
        return null;
    }

    @Override
    public Response<Long> create(UserOrderSaveRequest request) {
        return null;
    }
}
