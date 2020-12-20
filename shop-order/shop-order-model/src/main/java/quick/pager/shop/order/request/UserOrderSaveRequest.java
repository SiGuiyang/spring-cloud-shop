package quick.pager.shop.order.request;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.order.enums.OrderStatusEnums;
import quick.pager.shop.order.enums.OrderTypeEnums;
import quick.pager.shop.order.enums.PayTypeEnums;
import quick.pager.shop.user.request.Request;

/**
 * 用户订单保存
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserOrderSaveRequest extends Request {
    private static final long serialVersionUID = 3403409533500804139L;

    /**
     * 配送地址
     */
    private Long addrId;
    /**
     * 优惠券主键
     */
    private Long couponId;
    /**
     * 订单状态
     *
     * @see quick.pager.shop.order.enums.OrderStatusEnums
     */
    private OrderStatusEnums orderStatus;
    /**
     * 订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单
     *
     * @see quick.pager.shop.order.enums.OrderTypeEnums
     */
    private OrderTypeEnums orderType;
    /**
     * 配送时间
     */
    private String deliveryTime;
    /**
     * 支付方式
     * 0：支付宝
     * 1：微信
     */
    private PayTypeEnums payType;
    /**
     * 使用积分
     */
    private Integer integral;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    /**
     * 积分使用金额
     */
    private BigDecimal integralAmount;
    /**
     * 减免金额
     */
    private BigDecimal discountAmount;
    /**
     * 是否支持自提
     */
    private Boolean self;

}
