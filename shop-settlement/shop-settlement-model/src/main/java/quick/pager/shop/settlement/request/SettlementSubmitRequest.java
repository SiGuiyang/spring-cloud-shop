package quick.pager.shop.settlement.request;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 清结算支付成功后回调请求参数
 *
 * @author siguiyang
 */
@Data
public class SettlementSubmitRequest implements Serializable {
    private static final long serialVersionUID = 6111371882958044174L;

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
