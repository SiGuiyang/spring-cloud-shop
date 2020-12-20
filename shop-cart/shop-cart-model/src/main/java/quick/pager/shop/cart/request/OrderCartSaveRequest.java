package quick.pager.shop.cart.request;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 订单购物车
 *
 * @author siguiyang
 */
@Data
public class OrderCartSaveRequest implements Serializable {


    private static final long serialVersionUID = -6182261318305827394L;
    /**
     * 当前用户主键
     */
    private Long userId;
    /**
     * 冗余商户主键
     */
    private Long sellerId;
    /**
     * 用户订单主键
     */
    private Long userOrderId;
    /**
     * 商户订单主键
     */
    private Long sellerOrderId;
    /**
     * 订单商品
     */
    private List<OrderCartRequest> orderCarts;
}
