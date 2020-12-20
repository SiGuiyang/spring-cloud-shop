package quick.pager.shop.order.request;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.order.enums.OrderStatusEnums;
import quick.pager.shop.order.enums.OrderTypeEnums;
import quick.pager.shop.order.enums.PayTypeEnums;
import quick.pager.shop.user.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class SellerOrderSaveRequest extends Request {
    private static final long serialVersionUID = 2370158929485767003L;

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
     */
    private OrderStatusEnums orderStatus;
    /**
     * 订单类型
     */
    private OrderTypeEnums orderType;
    /**
     * 支付方式
     * 0：支付宝
     * 1：微信
     */
    private PayTypeEnums payType;
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
