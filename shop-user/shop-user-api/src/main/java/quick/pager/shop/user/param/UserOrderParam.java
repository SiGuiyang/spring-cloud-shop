package quick.pager.shop.user.param;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.AppDTO;

/**
 * 用户订单
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserOrderParam extends AppDTO {
    private static final long serialVersionUID = -5822489513088258957L;

    /**
     * 配送地址Id
     */
    private Long addressId;
    /**
     * 优惠券Id
     */
    private Long couponId;
    /**
     * 商家Id
     */
    private Long sellerId;

    /**
     * 订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单
     */
    private Integer orderType;

    /**
     * 配送时间<br /> 13:00-14:00
     */
    private String deliveryTime;
    /**
     * 是否是当天配送 <br />
     * 1 当天配送
     * 0 次日配送
     *
     */
    private String current;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 购买的商品
     */
    private List<GoodsCartDTO> goodsCart;

    @Data
    public static class GoodsCartDTO {
        /**
         * 购买的商品Id
         */
        private Long goodsId;
        /**
         * 购买的商品的数量
         */
        private Long goodsCount;
    }
}
