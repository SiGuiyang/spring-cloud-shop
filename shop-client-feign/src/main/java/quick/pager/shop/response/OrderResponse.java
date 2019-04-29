package quick.pager.shop.response;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import quick.pager.shop.model.DiscountCoupon;
import quick.pager.shop.model.Address;
import quick.pager.shop.model.UserOrder;
import quick.pager.shop.model.SellerInfo;

@Data
public class OrderResponse implements Serializable {
    private static final long serialVersionUID = 6604745333540588254L;
    // 订单信息
    private UserOrder userOrder;
    // 购买的商品信息
    private List<GoodsResponse> buyerGoods = Lists.newArrayList();
    // 优惠券信息
    private DiscountCoupon discountCoupon = new DiscountCoupon();
    // 配送地址
    private Address address;
    // 商家信息
    private SellerInfo seller;
}
