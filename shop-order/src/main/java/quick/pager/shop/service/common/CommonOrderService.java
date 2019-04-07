package quick.pager.shop.service.common;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.response.Response;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.client.GoodsClient;
import quick.pager.shop.client.UserClient;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.response.OrderResponse;
import quick.pager.shop.model.DiscountCoupon;
import quick.pager.shop.model.Address;
import quick.pager.shop.model.UserOrder;

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
