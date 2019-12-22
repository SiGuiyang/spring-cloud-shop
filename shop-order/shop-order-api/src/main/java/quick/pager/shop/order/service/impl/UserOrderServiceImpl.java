package quick.pager.shop.order.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import quick.pager.shop.order.request.OrderRequest;
import quick.pager.shop.order.request.UserOrderSaveRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.order.service.UserOrderService;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Override
    public Response<List<Object>> userOrderList(OrderRequest request) {
        return null;
    }

    @Override
    public Response<Object> userOrderDetail(Long orderId) {
        return null;
    }

    @Override
    public Response orderCreate(UserOrderSaveRequest request) {
        return null;
    }
}
