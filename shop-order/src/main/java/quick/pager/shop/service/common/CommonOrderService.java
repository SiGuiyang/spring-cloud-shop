package quick.pager.shop.service.common;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.SellerClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.model.SellerInfo;
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
    @Autowired
    private SellerClient sellerClient;

    /**
     * 通过一个订单查询这个订单的详情
     */
    public OrderResponse transOrder(UserOrder userOrder) {

        OrderResponse orderResponse = new OrderResponse();
        // 添加订单
        orderResponse.setUserOrder(userOrder);
        // 添加商品
        Response<List<GoodsResponse>> response = goodsClient.queryBuyerOrderGoods(userOrder.getBuyOrderCartId());
        if (ResponseStatus.Code.SUCCESS == response.getCode()) {
            orderResponse.setBuyerGoods(response.getData());
        }
        // 添加优惠券
        if (null != userOrder.getCouponId() && 0 != userOrder.getCouponId()) {
            Response<DiscountCoupon> discountCouponResponse = activityClient.userCoupons(userOrder.getCouponId());
            if (ResponseStatus.Code.SUCCESS == discountCouponResponse.getCode()) {
                orderResponse.setDiscountCoupon(discountCouponResponse.getData());
            }
        }
        // 添加配送地址
        Response<Address> addressResponse = userClient.queryAddress(userOrder.getShipId());
        if (ResponseStatus.Code.SUCCESS == addressResponse.getCode()) {
            orderResponse.setAddress(addressResponse.getData());
        }
        // 添加商家
        Response<SellerInfo> sellerResponse = sellerClient.querySeller(userOrder.getSellerId());
        if (ResponseStatus.Code.SUCCESS == sellerResponse.getCode()) {
            orderResponse.setSeller(sellerResponse.getData());
        }

        return orderResponse;

    }
}
