package quick.pager.shop.service.impl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.cart.request.OrderCartRequest;
import quick.pager.shop.cart.request.OrderCartSaveRequest;
import quick.pager.shop.cart.response.OrderCartResponse;
import quick.pager.shop.mapper.OrderCartMapper;
import quick.pager.shop.model.OrderCart;
import quick.pager.shop.service.OrderCartService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.DateUtils;

@Service
@Slf4j
public class OrderCartServiceImpl implements OrderCartService {

    @Autowired
    private OrderCartMapper orderCartMapper;


    @Override
    public Response<OrderCartResponse> orders(final OrderCartSaveRequest request) {

        List<OrderCartRequest> orderCarts = request.getOrderCarts();

        orderCarts.forEach(item -> {
            OrderCart orderCart = new OrderCart();
            orderCart.setUserId(request.getUserId());
            orderCart.setSellerId(request.getSellerId());
            orderCart.setSkuId(item.getSkuId());
            orderCart.setQuantity(item.getQuantity());
            orderCart.setDiscountAmount(item.getDiscountAmount());
            orderCart.setSkuAmount(item.getSkuAmount());
            orderCart.setUserOrderId(request.getUserOrderId());
            orderCart.setSellerOrderId(request.getSellerOrderId());
            orderCart.setCreateTime(DateUtils.dateTime());
            orderCart.setUpdateTime(DateUtils.dateTime());
            this.orderCartMapper.insert(orderCart);
        });

        return Response.toResponse();
    }
}
