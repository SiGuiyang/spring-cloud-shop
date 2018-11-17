package quick.pager.shop.model.order;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 用户订单
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserOrder extends Model {

    private static final long serialVersionUID = -8609992562795816920L;
    /**
     * 购买用户的Id
     */
    private Long userId;
    /**
     * 购买商品的商户的Id
     */
    private Long sellerId;
    /**
     * 被购买商品的Id
     */
    private Long goodsId;
    /**
     * 配送地址的Id
     */
    private Long shippingAddressId;
    /**
     * 购买商品的数量
     */
    private Integer goodsCount;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 购买商品所花费的积分
     */
    private Integer integral;

}
