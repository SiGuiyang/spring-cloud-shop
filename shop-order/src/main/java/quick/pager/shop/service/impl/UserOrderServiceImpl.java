package quick.pager.shop.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.order.OrderDTO;
import quick.pager.shop.model.order.UserOrder;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.UserOrderService;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Override
    public Response<List<Object>> userOrderList(OrderDTO dto) {
        return null;
    }

    @Override
    public Response<Object> userOrderDetail(Long orderId) {
        return null;
    }

    @Override
    public Response orderCreate(UserOrder userOrder) {
        return null;
    }
}
