package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单商品明细
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_order_item")
public class OrderItem extends Model {

    private static final long serialVersionUID = 331049701400102546L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 商户主键
     */
    private Long sellerId;
    /**
     * 订单主键
     */
    private Long userOrderId;
    /**
     * 商户订单主键
     */
    private Long sellerOrderId;
    /**
     * 购买商品主键
     */
    private Long goodsSkuId;
    /**
     * 购买商品花费金额
     */
    private BigDecimal purchaseAmount;
    /**
     * 购买商品数量
     */
    private Integer purchaseQuantity;


}
