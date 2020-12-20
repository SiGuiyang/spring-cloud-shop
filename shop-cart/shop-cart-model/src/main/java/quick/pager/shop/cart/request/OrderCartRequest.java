package quick.pager.shop.cart.request;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 订单购物车
 * 清结算服务使用
 */
@Data
public class OrderCartRequest implements Serializable {

    private static final long serialVersionUID = 8270206974651627286L;
    /**
     * 商品主键
     */
    private Long skuId;
    /**
     * 购买数量
     */
    private Integer quantity;
    /**
     * 商品价格
     */
    private BigDecimal skuAmount;
    /**
     * 折扣价格
     */
    private BigDecimal discountAmount;
}
