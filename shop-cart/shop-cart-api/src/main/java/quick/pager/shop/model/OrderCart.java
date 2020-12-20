package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>购买商品生成的购物车</p>
 * <p>这里的购物车是用户已经下单，与订单绑定关联关系</p>
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_order_cart")
public class OrderCart extends Model {
    private static final long serialVersionUID = -3752936329211285384L;

    /**
     * 用户主键
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
     * 商品sku主键
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
