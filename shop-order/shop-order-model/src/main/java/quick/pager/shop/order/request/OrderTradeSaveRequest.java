package quick.pager.shop.order.request;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.order.enums.PayTypeEnums;
import quick.pager.shop.order.enums.TradeTypeEnums;
import quick.pager.shop.user.request.Request;

/**
 * 交易流水
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class OrderTradeSaveRequest extends Request {
    private static final long serialVersionUID = -9199232932821616501L;

    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 交易类型
     */
    private TradeTypeEnums tradeType;
    /**
     * 支付方式
     */
    private PayTypeEnums payType;
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
