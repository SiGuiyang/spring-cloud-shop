package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 交易流水
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("t_order_trade")
public class OrderTrade extends Model {
    private static final long serialVersionUID = -3295486564880071298L;

    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 交易类型
     */
    private Integer tradeType;
    /**
     * 支付方式
     *
     * @see quick.pager.shop.order.enums.TradeTypeEnums
     */
    private Integer payType;
    /**
     * 商户网站唯一订单号
     */
    private String outTradeNo;
    /**
     * 支付宝系统中的交易流水号
     */
    private String tradeNo;
    /**
     * 订单的资金总额
     */
    private BigDecimal totalAmount;

}
