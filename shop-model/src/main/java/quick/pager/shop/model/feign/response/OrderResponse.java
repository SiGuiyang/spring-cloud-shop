package quick.pager.shop.model.feign.response;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.model.common.Address;
import quick.pager.shop.model.order.UserOrder;
import quick.pager.shop.model.seller.SellerInfo;

@Data
public class OrderResponse implements Serializable {
    private static final long serialVersionUID = 6604745333540588254L;
    // 订单信息
    private UserOrder userOrder;
    // 购买的商品信息
    private List<GoodsResponse> buyerGoods;
    // 优惠券信息
    private DiscountCoupon discountCoupon;
    // 配送地址
    private Address address;
    // 商家信息
    private SellerInfo seller;
}
