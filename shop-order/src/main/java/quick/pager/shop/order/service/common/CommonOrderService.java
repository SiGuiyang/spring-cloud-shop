package quick.pager.shop.order.service.common;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.response.Response;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.model.common.Address;
import quick.pager.shop.model.feign.response.GoodsResponse;
import quick.pager.shop.model.feign.response.OrderResponse;
import quick.pager.shop.model.order.UserOrder;
import quick.pager.shop.order.client.ActivityClient;
import quick.pager.shop.order.client.GoodsClient;
import quick.pager.shop.order.client.UserClient;

@Service
@Slf4j
public class CommonOrderService {

    @Autowired
    private UserClient userClient;
    @Autowired
    private GoodsClient goodsClient;
    @Autowired
    private ActivityClient activityClient;

    /**
     * 通过一个订单查询这个订单的详情
     *
     * @param userOrder 订单的实例
     */
    public OrderResponse transOrder(UserOrder userOrder) {

        OrderResponse orderResponse = new OrderResponse();

        // 优惠券
        Response<DiscountCoupon> couponResponse = new Response<>();
        if (null != userOrder.getCouponId()) {
            couponResponse = activityClient.userCoupons(userOrder.getCouponId());
        }

        // 地址
        Response<Address> addressResponse = userClient.queryAddress(userOrder.getShipId());
        // 商品
        Response<List<GoodsResponse>> response = goodsClient.queryBuyerOrderGoods(userOrder.getBuyOrderCartId());

        orderResponse.setBuyerGoods(response.getData());
        orderResponse.setUserOrder(userOrder);
        orderResponse.setAddress(addressResponse.getData());
        orderResponse.setDiscountCoupon(couponResponse.getData());

        return orderResponse;

    }
}
