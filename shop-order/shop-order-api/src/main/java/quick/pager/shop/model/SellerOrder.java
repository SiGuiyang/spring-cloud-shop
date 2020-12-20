package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 商户订单
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_seller_order")
public class SellerOrder extends Model {

    private static final long serialVersionUID = 5577928979748151630L;

    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 商户主键
     */
    private Long sellerId;
    /**
     * 配送地址
     */
    private Long addrId;
    /**
     * 商户订单号
     */
    private String orderCode;
    /**
     * 配送时间
     */
    private String deliveryTime;
    /**
     * 订单状态
     *
     * @see quick.pager.shop.order.enums.OrderStatusEnums
     */
    private Integer orderStatus;
    /**
     * 订单类型
     */
    private Integer orderType;
    /**
     * 支付方式
     * 0：支付宝
     * 1：微信
     *
     * @see quick.pager.shop.order.enums.PayTypeEnums
     */
    private Integer payType;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 折扣金额
     */
    private BigDecimal discountAmount;
    /**
     * 是否支持自提
     */
    private Boolean self;

}
